import { connect } from "react-redux";
import Nav from "./nav";

function isActive(path) {
    return window.location.pathname.startsWith(path);
  }

  //전달된 props 상태 확인후 communities 할당.
function SideNav({user}) {
    if(user[0] === undefined) {
        const communities = <Nav.Link></Nav.Link>;
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
    } else {
        const communities = user[0].map((community) => <Nav.Link key={community.id} to={`/board/${community.url}`}>{community.name}</Nav.Link>);
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
}

//store에서 정보를 가져오고 props로 전달
function mapStateToProps(state) {
    return {user:state};
}

export default connect(mapStateToProps)(SideNav);