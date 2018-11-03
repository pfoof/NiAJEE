import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListBooksComponent} from './components/list-books/list-books.component';
import {ViewBookComponent} from './components/view-book/view-book.component';
import {ListAuthorsComponent} from './components/list-authors/list-authors.component';
import {EditBookComponent} from './components/edit-book/edit-book.component';

const routes: Routes = [
  {path: '', component: ListBooksComponent},
  {path: 'books/new', component: EditBookComponent},
  {path: 'books/:id', component: ViewBookComponent},
  {path: 'books/:id/edit', component: EditBookComponent},
  {path: 'authors', component: ListAuthorsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
