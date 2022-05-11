import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Post } from '../post';
import { CommentsComponent } from './comments/comments.component';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  @Input() postItem: Post;
  @Input() showOrHidePostItem;
  
  @ViewChild(CommentsComponent) comments: CommentsComponent;

  constructor() { }

  ngOnInit(): void {
  }

  getPostComments(postItemId: string) {
    this.comments.getComments(postItemId);
  }

}
