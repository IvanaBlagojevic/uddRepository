import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService/user.service';
import { UserDTO } from '../model/UserDTO';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { ScfieldService } from '../services/scfieldService/scfield.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private enumValues = [];

  dropdownList = [];
  selectedItems = [];
  dropdownSettings : IDropdownSettings;

  constructor(private us: UserService, private scfs: ScfieldService) {
    let x = us.startProcess();
    console.log("ivana",x);
    this.scfs.getFields().subscribe(data=>{
      this.enumValues = data;
      this.enumValues.forEach(element => {
        let here = { item_id: element.number, item_text: element.name };
        this.dropdownList.push(here);
      });
    })

    
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      allowSearchFilter: true,
      
    };
    

    x.subscribe(
      res => {
        console.log("ivana",res);
        //this.categories = res;
        this.formFieldsDto = res;
        this.formFields = res.formFields;
        this.processInstance = res.processInstanceId;
        this.formFields.forEach( (field) =>{
          
          if( field.type.name=='enum'){
            this.enumValues = this.dropdownList;
          }
        });
      },
      err => {
        console.log("Error occured");
      }
    );
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
      if (property=="email") {
        email = value[property];
      }

      if (property!="scfields") {
        o.push({fieldId : property, fieldValue : value[property]});
      }else{
        let all = [];
          value[property].forEach(element => {
              all.push(element.item_id);
          });
        o.push({fieldId: property, areas: all});
      }
     
    }
    
   

    console.log(o);
    console.log(this.selectedItems);
    let x = this.us.postUser(o, this.formFieldsDto.taskId);

    x.subscribe(
      res => {
        console.log(res);
       
        alert("You registered successfully!");
        window.location.href = email+"/"+this.processInstance+"/confirmRegistration";
      },
      err => {
        console.log("Error occured");
      }
    );
  }

}
