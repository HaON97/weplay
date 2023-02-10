import Nav from 'react-bootstrap/Nav';
import 'bootstrap'
const Header = () => {
    return (
        <>
            <Nav className="justify-content-end" activeKey="/home">
                <Nav.Item>
                <Nav.Link href="/">Log-In</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                <Nav.Link eventKey="link-1">Link</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                <Nav.Link eventKey="link-2">Link</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                <Nav.Link eventKey="disabled" disabled>
                    Disabled
                </Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    );

}
export default Header;