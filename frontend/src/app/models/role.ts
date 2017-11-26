export class Role {
  public static CUSTOMER = 'ROLE_CUSTOMER';
  public static EMPLOYEE = 'ROLE_EMPLOYEE';
  public static MANAGER = 'ROLE_MANAGER';
  public static ADMIN = 'ROLE_ADMIN';

  public static COLORS = {
    [Role.CUSTOMER]: 'success',
    [Role.EMPLOYEE]: 'primary',
    [Role.MANAGER]: 'warning',
    [Role.ADMIN]: 'danger'
  };

  public static toString(role: string): string {
    switch (role) {
      case Role.CUSTOMER:
        return 'Customer';
      case Role.EMPLOYEE:
        return 'Employee';
      case Role.MANAGER:
        return 'Manager';
      case Role.ADMIN:
        return 'Admin';
    }
  }
}
