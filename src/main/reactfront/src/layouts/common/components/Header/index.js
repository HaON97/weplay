import Nav from 'react-bootstrap/Nav';
import 'bootstrap/dist/css/bootstrap.min.css';

function link(props){
    console.log(props);
}

const Header = () => {
    return (
        <>
            <Nav className="justify-content-end">
                <Nav.Item>
                <Nav.Link onClick={link("/signUp")}>Sign-Up</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                <Nav.Link>Schedule</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                <Nav.Link>Profile</Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    );

}
export default Header;