import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments: Comment[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  getComments(postItemId: string) {
    this.http.get<any>('/rest/rest/posts/'+postItemId+'/comments')
      .subscribe(data => this.comments = data);
  }

}
