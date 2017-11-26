import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-profile-information-admin',
  templateUrl: './profile-information-admin.component.html',
  styleUrls: ['./profile-information-admin.component.css']
})
export class ProfileInformationAdminComponent implements OnInit {
  constructor(private authService: AuthService) { }

  ngOnInit() {
  }
}
