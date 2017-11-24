import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {
  notification = '';
  type: string;

  constructor() { }

  success(notification: string): void {
    this.notification = notification;
    this.type = 'success';
  }

  info(notification: string): void {
    this.notification = notification;
    this.type = 'info';
  }

  warning(notification: string): void {
    this.notification = notification;
    this.type = 'warning';
  }

  error(notification: string): void {
    this.notification = notification;
    this.type = 'danger';
  }

  clear(): void {
    this.notification = '';
  }
}
