import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserDTO } from '../model/UserDTO';
import { UserService } from '../services/userService/user.service';
import { MagazineService } from '../services/magazineService/magazine.service';
import { MagazineDTO } from '../model/MagazineDTO';
import { RepositoryService } from '../services/repostoryService/repository.service';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { SearchService } from '../services/searchService/search.service';
import { AdvancedQueryDTO } from '../model/AdvancedQueryDTO';
import { AdvancedQuerySendDTO } from '../model/AdvancedQuerySendDTO';
import { ArticleDTO } from '../model/ArticleDTO';
import { saveAs } from 'file-saver';
import { ArticleService } from '../services/articleService/article.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  private formFieldsDto = null;
  private formFields = [];
  private processInstance = "";
  private taskId = "";

  someoneLogged : boolean = false;
  adminLogged : boolean = false;
  email : string = "";
  loggedUser : UserDTO;
  editorLogged : boolean = false;
  isEditorInMagzine = false;
  isAuthor = false;

  journals: MagazineDTO[];


  enumValues = [];
  dropdownList = [];
  selectedItems = [];
  dropdownSettings : IDropdownSettings;


  //basic query
  basicQuery :string= "" ;
  private articlesBasic = Array<ArticleDTO>();

  //advanced
  private listFields = Array<AdvancedQueryDTO>();
  private listFieldsSend = Array<AdvancedQuerySendDTO>();
  private articlesAdvanced = [];

  //download
 

  constructor(private tokenStorage : TokenStorageService,private us : UserService, private ms : MagazineService,
    private rs : RepositoryService, private ss: SearchService, private as : ArticleService) { 
      this.dropdownList = [
        {item_id: "all", item_text: "all fields"},
        {item_id: "magazine", item_text: "magazine name"},
        {item_id: "heading", item_text: "heading"},
        {item_id: "author", item_text: "name/surname author"},
        {item_id: "coauthor", item_text: "name/surname coauthor"},
        {item_id: "keyterms", item_text: "keyterms"},
        {item_id: "content", item_text: "content"},
        {item_id: "mainSC", item_text: "main scientific field"},
      ];

      this.dropdownSettings = {
        singleSelection: true,
        idField: 'item_id',
        textField: 'item_text',
        selectAllText: 'Select All',
        unSelectAllText: 'UnSelect All',
        allowSearchFilter: true,
      }

    }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.someoneLogged = true;
      let jwt = this.tokenStorage.getToken();
      console.log("Tokeen: " + jwt);
      let jwtData = jwt.split('.')[1];
      let decodedJwtJsonData = window.atob(jwtData);
      let decodedJwtData = JSON.parse(decodedJwtJsonData);
      this.email = decodedJwtData.sub;

      this.us.getUserByEmail(this.email).subscribe(data =>{
        console.log("data " + data);
        this.loggedUser = data as UserDTO;
        console.log(data);
        if (this.loggedUser.magazine != undefined){
          this.isEditorInMagzine = true;
        }

        this.loggedUser.roles.forEach(element =>{
          //console.log("Uloga: " + element.name);
          if(element.name === "ADMIN")
          {
            this.adminLogged = true;
          }else if (element.name === "EDITOR") {
            this.editorLogged = true;
          }else if (element.name === "AUTHOR") {
            this.isAuthor = true;
            console.log("autor je");
          }
        });
      });
  }

  }

  logout(){
    this.tokenStorage.signOut();
    this.someoneLogged = false;
    window.location.href="http://localhost:4200";
  }

  seeList(){
    console.log("ivana");
    this.ms.getAll().subscribe(
      data=>{
        this.journals=data;
        console.log(this.journals);
      }
    )
  }

  addArticle(jurnal : any) {
    this.rs.startProcess("article_process", jurnal).subscribe(data=>{
      console.log(data);
      this.formFieldsDto = data;
      this.formFields = data.formFields;
      this.processInstance = data.processInstanceId;
      this.taskId = data.taskId;
      window.location.href="/admin";
      //window.location.href="/addArticle/"+this.taskId+"/"+jurnal.issn+"/article";
    },
    err => {
      console.log("Error occured");
    })

    
  }


  onItemSelect(item: any) {
    this.selectedItems.push(item.item_id);
  }

  onItemDeSelect(item: any) {
    this.selectedItems.splice(item,1);
  }

  addField() {
    let newM = new AdvancedQueryDTO();
   
    this.listFields.push(newM);
  }

  onSubimitBasic() {
    var field = "";
    this.selectedItems.forEach(element =>{
      console.log("SELECTED " + element);
      field = element;
    })
    
    console.log("query " + this.basicQuery);
    this.ss.searchBasic(field, this.basicQuery).subscribe(data=>{
      console.log(data);
      this.articlesBasic = data;
    },
    err => {
      console.log("Error occured");
    })
  }


  onSubmitAdvanced() {
    this.listFieldsSend = [];
    this.listFields.forEach(element =>{
      var field;
      element.field.forEach(el => {
        console.log("FIELD " + el.item_id);
        field = el.item_id;
      });
      
      console.log("PHRASE " + element.isPhrase);
      console.log("OPERATION " + element.operation);
      console.log("QUERY " + element.query);
      var advanced = new AdvancedQuerySendDTO();
      if (element.isPhrase == undefined || element.isPhrase == false) {
        advanced.phrase = false;
      }else{
        advanced.phrase = true;
      }
      
      advanced.query = element.query;
      advanced.operation = element.operation;
      advanced.field = field;
      this.listFieldsSend.push(advanced);
    })
    
    console.log(this.listFieldsSend);
    this.ss.searchAdvanced(this.listFieldsSend).subscribe(data=>{
      console.log(data);
      this.articlesAdvanced = data;
      this.listFieldsSend = [];
    },
    err => {
      console.log("Error occured");
    })
  }


  download(pdfUrl: string) {
   // var splitted = pdfUrl.split("\\");
   // pdfUrl = splitted[splitted.length-1]
   
    this.as.downloadFile(pdfUrl).subscribe(res => {
        console.log(res);
        saveAs(res, pdfUrl);
    });

  }
 

}
