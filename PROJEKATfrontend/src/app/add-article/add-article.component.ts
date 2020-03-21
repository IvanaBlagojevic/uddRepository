import { Component, OnInit } from '@angular/core';
import { RepositoryService } from '../services/repostoryService/repository.service';
import { ActivatedRoute } from '@angular/router';
import { ScfieldService } from '../services/scfieldService/scfield.service';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { ArticleService } from '../services/articleService/article.service';
import { UserService } from '../services/userService/user.service';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {

  private op = "new";
  private what = "";
  private issn = "";
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";

  private enumValues = [];
  dropdownList = [];
  selectedItems = [];
  dropdownSettings : IDropdownSettings;

  fileUrl: string;
  fileToUpload: File;

  constructor(private us:UserService,private route: ActivatedRoute, private rs : RepositoryService, private scfs: ScfieldService,
    private as: ArticleService) {
    this.op = this.route.snapshot.params.op;
    
    this.what = this.route.snapshot.params.what;
    if (this.what == "article"){
      this.issn = this.route.snapshot.params.issn;
    }
    

    console.log("op " + this.op);

    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      allowSearchFilter: true,

    };
    

    this.scfs.getFields().subscribe(data=>{
      this.enumValues = data;
      this.enumValues.forEach(element => {
        let here = { item_id: element.number, item_text: element.name };
        this.dropdownList.push(here);
      });
    })

    if (this.what == "article" || this.what=="coauthorPage") {
      this.rs.getTask(this.op).subscribe(data=>{
        this.formFieldsDto = data;
        this.formFields = data.formFields;
        this.processInstance = data.processInstanceId;
        
      },
      err => {
        console.log("Error occured");
      })
  
    }else{
      us.getConfirmForm(this.op).subscribe(
        res => {
          this.formFieldsDto = res;
          this.formFields = res.formFields;
          this.processInstance = res.processInstanceId;
        },
        err => {
          console.log("Error occured");
        }
      );
    }
    
   }

  ngOnInit() {
  }


  onItemSelect(item: any) {

      this.selectedItems.push(item);
    
    
  }
  onSelectAll(items: any) {
    
      this.selectedItems.push(items);
    
  }
  onItemDeSelect(item: any) {
    this.selectedItems.splice(item,1);

  }

  onSubmit(value, form){
    let o = new Array();
    let email = "";
    for (var property in value) {
      console.log(property);
      console.log(value[property]);
     
      if (property!="scientificField") {
        o.push({fieldId : property, fieldValue : value[property]});
      }else{
        let all = [];
          value[property].forEach(element => {
              all= element.item_id;
          });
        o.push({fieldId: property, fieldValue: all});
      }

    }
    
   
    
    console.log(o);
    console.log(this.selectedItems);
    if (this.what == "article" ){
      //o.push({fieldId : "issn", fieldValue : this.issn});
      this.as.postFile(this.fileToUpload).subscribe(data=>{
        o.push({fieldId : "pdf", fieldValue : data});
        this.as.postArticle(o, this.formFieldsDto.taskId).subscribe(data=>{
          alert("New article");
          window.location.href = "admin";
          //window.location.href="/addArticle/"+this.processInstance+"/"+this.issn+"/coauthor";
          //window.location.href = "checkArticle/"+this.processInstance+"/new";
        });
        // window.location.href = this.processInstance+"/choose/first";
        },
        err => {
          console.log("Error occured");
        })
    }else{
      this.rs.submitTask(this.formFieldsDto.taskId,o).subscribe(data=>{
        alert("Added coauthor");
        window.location.href="admin";
        //window.location.href = "checkArticle/"+this.processInstance+"/new";
      },
      err => {
        console.log("Error occured");
      });
    }
  }
    
    
    handleFileInput(file:FileList){
      this.fileToUpload =file.item(0);
      var reader = new FileReader();
      reader.onload=(event:any)=>{
        this.fileUrl =event.target.result;//ovo ne radi za pdf nesto
      }
      reader.readAsDataURL(this.fileToUpload);
      console.log("URL "+this.fileUrl);
      console.log("file "+this.fileToUpload);
  }

}
