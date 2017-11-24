import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { NotificationService } from '../services/notification/notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  constructor(private notificationService: NotificationService) { }

  ngOnInit() {
  }

  dismiss() {
    this.notificationService.clear();
  }
}
