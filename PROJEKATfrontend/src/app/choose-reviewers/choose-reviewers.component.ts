import { Component, OnInit } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { ActivatedRoute } from '@angular/router';
import { RepositoryService } from '../services/repostoryService/repository.service';
import { ArticleService } from '../services/articleService/article.service';

@Component({
  selector: 'app-choose-reviewers',
  templateUrl: './choose-reviewers.component.html',
  styleUrls: ['./choose-reviewers.component.css']
})
export class ChooseReviewersComponent implements OnInit {

  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";


  enumValuesReviewers = [];
  dropdownListReviewers = [];
  selectedItemsReviewers = [];
  dropdownSettings : IDropdownSettings;

  taskId = "";
  sel: boolean;

  constructor(private route: ActivatedRoute, private rs: RepositoryService, private as: ArticleService) {
    this.taskId = this.route.snapshot.params.tid;
    this.sel = false;
    /*this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      allowSearchFilter: true,

    };*/

    
    rs.getTask(this.taskId).subscribe(
      res => {
        console.log(res);
        this.formFieldsDto = res;
        this.formFields = res.formFields;
        this.processInstance = res.processInstanceId;
        this.formFields.forEach(element => {
          if (element.id == "review"){
            this.enumValuesReviewers = Object.entries(element.type.values);
            this.enumValuesReviewers.forEach(back => {
              console.log("sta ima " + back);
              let here = { item_id: back[0], item_text: back[1]};
              console.log(here);
              this.dropdownListReviewers.push(here);
            });
          }
          if (element.id == "yes") {
              if (element.defaultValue == "true") {
                  this.sel = true;
              }
          }
        });
        console.log("SEL " +this.sel);
        this.dropdownSettings = {
          singleSelection: this.sel,
          idField: 'item_id',
          textField: 'item_text',
          selectAllText: 'Select All',
          unSelectAllText: 'UnSelect All',
          allowSearchFilter: true,
    
        };
        
      },
      err => {
        console.log("Error occured");
      }
    );

   }

  ngOnInit() {
  }

  onItemSelect(item: any) {
    this.selectedItemsReviewers.push(item);
  }
  onSelectAll(items: any) {
    this.selectedItemsReviewers.push(items);
  }
  onItemDeSelect(item: any) {
    this.selectedItemsReviewers.splice(item,1);
  }

  onSubmit(value, form){
    let o = new Array();
    let email = "";
    for (var property in value) {
      console.log(property);
      console.log(value[property]);

      if (property!="review") {
        o.push({fieldId : property, fieldValue : value[property]});
      }else{
        if (value[property] != "") {
          let all = [];
          let number = 0;
            value[property].forEach(element => {
                all.push(element.item_id);
                number = number + 1;
            });
          o.push({fieldId: property, areas: all});
        }
        
      }
     
    }
    console.log(o);

    this.as.choosenReviewers(o, this.formFieldsDto.taskId).subscribe(data=>{
        alert("Added");
        window.location.href = "";
    },
    err => {
      console.log("Error occured");
    })
    
  }

}
