import Nav from "./nav";

const community = [{
    id : 1,
    name : "놀자에요",
    url : ""
},
{
    id :2,
    name : "로아톡",
    url : ""
}];

const communities = community.map((community) => <Nav.Link>{community.name}</Nav.Link>);

function isActive(path) {
    return window.location.pathname.startsWith(path);
  }

function SideNav() {
    return (

        <Nav>
            <Nav.List>
                <Nav.Item>
                    <Nav.Link to='/'>
                        Home
                    </Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link to='/'>
                        Profile
                    </Nav.Link>
                </Nav.Item>
                <Nav.Separator />
                <Nav.Item>
                    <Nav.Link to='/region-raid/kuku' active={isActive("/region-raid")}>
                        Region Raid
                    </Nav.Link>
                    <Nav.List expanded={isActive("/region-raid")}>
                        <Nav.Item>
                            <Nav.Link to='/region-raid/kuku'>
                                쿠크
                            </Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link to='/region-raid/ab'>
                                아브
                            </Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link to='/region-raid/12'>
                                일리
                            </Nav.Link>
                        </Nav.Item>
                    </Nav.List>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link to='/abyss' active={isActive("/abyss")}>
                        Abyss
                    </Nav.Link>
                    <Nav.List expanded={isActive("/abyss")}>
                        <Nav.Item>
                            <Nav.Link to='/abyss/kayang'>
                                카양겔
                            </Nav.Link>
                        </Nav.Item>
                        <Nav.Item>
                            <Nav.Link to='/region-raid/top'>
                                상아탑
                            </Nav.Link>
                        </Nav.Item>
                    </Nav.List>
                </Nav.Item>
                <Nav.Separator />
                <Nav.Item>{communities}</Nav.Item>
            </Nav.List>
        </Nav>

    )
}

export default SideNav;