import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListBooksComponent} from './components/list-books/list-books.component';
import {ViewBookComponent} from './components/view-book/view-book.component';
import {ListAuthorsComponent} from './components/list-authors/list-authors.component';
import {EditBookComponent} from './components/edit-book/edit-book.component';

const routes: Routes = [
  { path: '', component: ListBooksComponent},
  { path: 'keyparts/new', component: EditBookComponent},
  { path: 'keyparts/:id', component: ViewBookComponent},
  { path: 'keyparts/:id/edit', component: EditBookComponent},
  { path: 'users', component: ListAuthorsComponent },
  { path: 'users/:id', component: ListUsersComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
