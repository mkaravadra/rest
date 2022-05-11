import { Component, ViewChild } from '@angular/core'; 
import { PostsComponent } from './posts/posts.component';
import { UsersComponent } from './users/users.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Posts';
  hidePosts = true;
  hideUsers = true;

  @ViewChild(PostsComponent) posts:PostsComponent;
  @ViewChild(UsersComponent) users:UsersComponent;

  onShowPosts() {
    this.hidePosts = false;
    this.hideUsers = true;
    this.posts != null ? this.posts.showOrHidePostItem = false : null;
    this.users != null ? this.users.showOrHideUserItem = false : null;
    this.users != null ? this.users.clearUsers() : null;
    this.posts != null ? this.posts.getPosts() : null;
  }

  onShowUsers() {
    this.hideUsers = false;
    this.hidePosts = true;
    this.posts != null ? this.posts.showOrHidePostItem = false : null
    this.users != null ? this.users.showOrHideUserItem = false : null;
    this.posts != null ? this.posts.clearPosts() : null;
    this.users != null ? this.users.getUsers() : null;
  }

}
