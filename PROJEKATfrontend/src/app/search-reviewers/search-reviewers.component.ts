import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArticleService } from '../services/articleService/article.service';
import { ScfieldService } from '../services/scfieldService/scfield.service';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { SearchService } from '../services/searchService/search.service';
import { ReviewerRequestDTO } from '../model/ReviewerRequestDTO';

@Component({
  selector: 'app-search-reviewers',
  templateUrl: './search-reviewers.component.html',
  styleUrls: ['./search-reviewers.component.css']
})
export class SearchReviewersComponent implements OnInit {

  //choosen article
  private id;
  private article;
  
  //all sc fields
  enumValues = [];
  dropdownList = [];
  selectedItems = [];
  dropdownSettings : IDropdownSettings;
  myForm:FormGroup;

  //a
  private a : String = "";

  //request
  private back : ReviewerRequestDTO = new ReviewerRequestDTO();
  isMoreLikeThis = false;
  isInDomain = false;
  listReviewers = [];

  constructor(private route: ActivatedRoute,private as : ArticleService,  private scfs: ScfieldService, private fb: FormBuilder,
    private ss : SearchService) { 
    this.id = this.route.snapshot.params.id;


    this.scfs.getFields().subscribe(data=>{
      this.enumValues = data;
      this.enumValues.forEach(element => {
        let here = { item_id: element.number, item_text: element.name };
        this.dropdownList.push(here);
      });
    })
    
    this.dropdownSettings = {
      singleSelection: true,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      allowSearchFilter: true,

    };

    this.myForm = this.fb.group({
      ime: [this.dropdownList],
      more : new FormControl(),
      km : new FormControl()
    });

    

    
      this.as.getById(this.id).subscribe(data=>{
        this.article = data;
        console.log(data);
        },
        err => {
          console.log("Error occured");
        })
      
  
      
        console.log("DROPDOWN" + this.dropdownList);
      
        
       

        
    
  }

  ngOnInit() {

    
  }


  onSubimitBasic() {
    console.log("query " + this.selectedItems);
    this.back.fields = this.selectedItems;
    this.back.moreLikeThis = this.isMoreLikeThis;
    this.back.inDomain = this.isInDomain;
    console.log("back " + this.back);
    console.log("isMoreLikeThis " + this.isMoreLikeThis);
    console.log("isInDomain " + this.isInDomain);

    this.ss.searchReviewers(this.id, this.back).subscribe(data=>{
      console.log(data);
      this.listReviewers = data;
    },
    err => {
      console.log("Error occured");
    })
  }


  onItemSelect(item: any) {
    this.selectedItems = [];
    this.selectedItems.push(item.item_id);
  }

  onItemDeSelect(item: any) {
    this.selectedItems = [];
    //this.selectedItems.splice(item.item_id,1);
  }

  


}
