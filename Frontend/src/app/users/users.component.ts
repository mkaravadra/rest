import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from './user';
import { UserComponent } from './user/user.component';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  userItem: User;
  users: User[] = [];
  showOrHideUserItem = false;

  @ViewChild(UserComponent) user: UserComponent;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  getUsers(): void {
    this.http.get<any>('/rest/rest/users')
      .subscribe(data => this.users = data);
  }

  clearUsers(): void {
    this.users = [];
  }

  onShowOrHideUserItem(userItem: User) {
    this.showOrHideUserItem = !this.showOrHideUserItem;
    this.userItem = userItem;
  }

}
