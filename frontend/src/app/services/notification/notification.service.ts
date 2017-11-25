import { Injectable } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { Observable } from 'rxjs/Observable';
import { timer } from 'rxjs/observable/timer';

@Injectable()
export class NotificationService {
  private notification = '';
  private type: string;
  private subscription: Subscription;
  private timer = timer(5000);

  constructor() { }

  startNotification(notification: string) {
    this.notification = notification;

    this.subscription = this.timer.subscribe(t => {
      this.clear();
      this.subscription.unsubscribe();
    });
  }

  success(notification: string): void {
    this.startNotification(notification);
    this.type = 'success';
  }

  info(notification: string): void {
    this.startNotification(notification);
    this.type = 'info';
  }

  warning(notification: string): void {
    this.startNotification(notification);
    this.type = 'warning';
  }

  error(notification: string): void {
    this.startNotification(notification);
    this.type = 'danger';
  }

  clear(): void {
    this.notification = '';
  }
}
