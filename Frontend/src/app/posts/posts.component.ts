import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from './post';
import { PostComponent } from './post/post.component';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  postItem: Post;
  posts: Post[] = [];
  showOrHidePostItem = false;

  @ViewChild(PostComponent) post: PostComponent;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  getPosts(): void {
    this.http.get<any>('/rest/rest/posts')
      .subscribe(data => this.posts = data);
  }

  clearPosts(): void {
    this.posts = [];
  }

  onShowOrHidePostItem(postItem: Post) {
    this.showOrHidePostItem = !this.showOrHidePostItem;
    this.postItem = postItem;
    this.post.getPostComments(postItem.id);
  }

}
