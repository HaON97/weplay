import React, { Component } from 'react';
import SidebarMenu, {SidebarMenuBody, SidebarMenuSub, SidebarMenuNavItem} from 'react-bootstrap-sidebar-menu';
class SideNavbar extends Component {
    
  constructor(props) {
    super(props);
    this.state = {
      isVisible: true
    };
  }

  render() {
    return (
        <SidebarMenu onToggle={true}>
            <SidebarMenuBody>
                <SidebarMenuNavItem>
                    haha
                    <SidebarMenuSub>
                        hello
                    </SidebarMenuSub>
                    <SidebarMenuSub>
                        hello2
                    </SidebarMenuSub>
                </SidebarMenuNavItem>
            </SidebarMenuBody>
        </SidebarMenu>
    );
  }
}

export default SideNavbar;