import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes, ActivatedRoute } from '@angular/router';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

import { RegistrationComponent } from './registration/registration.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HomepageComponent } from './homepage/homepage.component';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { AddArticleComponent } from './add-article/add-article.component';
import { ChooseReviewersComponent } from './choose-reviewers/choose-reviewers.component';
import { SearchReviewersComponent } from './search-reviewers/search-reviewers.component';

const appRoutes: Routes = [
          {path: "", component: HomepageComponent},
          {path: "registrate", component: RegistrationComponent},
          {path: "login" , component: LoginPageComponent},
          {path: "addArticle/:op/:issn/:what", component :AddArticleComponent},
          {path: ":tid/chooseReviewers", component: ChooseReviewersComponent},
          {path: "searchReviewers/:id", component:SearchReviewersComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginPageComponent,
    HomepageComponent,
    AddArticleComponent,
    ChooseReviewersComponent,
    SearchReviewersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgMultiSelectDropDownModule.forRoot(),
    RouterModule.forRoot(
      appRoutes,
      {enableTracing : true}
    )
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
