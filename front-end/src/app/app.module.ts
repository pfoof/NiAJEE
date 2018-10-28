import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './components/app/app.component';
import {AppRoutingModule} from './app-routing.module';
import {ListBooksComponent} from './components/list-books/list-books.component';
import {ViewBookComponent} from './components/view-book/view-book.component';
import {HttpClientModule} from '@angular/common/http';
import {BooksService} from './services/books.service';
import {ListAuthorsComponent} from './components/list-authors/list-authors.component';
import {EditBookComponent} from './components/edit-book/edit-book.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    ListBooksComponent,
    ViewBookComponent,
    ListAuthorsComponent,
    EditBookComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,

    AppRoutingModule
  ],
  providers: [BooksService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
