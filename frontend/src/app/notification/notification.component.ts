import { Component, OnInit, OnDestroy } from '@angular/core';
import { NotificationService } from '../services/notification/notification.service';
import { style, state, animate, transition, trigger } from '@angular/animations';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [
        style({
          transform: 'translateY(-100%)',
          opacity: 0
        }),
        animate(100, style({
          transform: 'translateY(0)',
          opacity: 1
        }))
      ]),
      transition(':leave', [
        style({
          transform: 'translateY(0)',
          opacity: 1
        }),
        animate(100, style({
          transform: 'translateY(-100%)',
          opacity: 0
        }))
      ])
    ])
  ]
})
export class NotificationComponent implements OnInit {
  constructor(private notificationService: NotificationService) { }

  ngOnInit() {
  }

  dismiss() {
    this.notificationService.clear();
  }
}
