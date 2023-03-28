import styled from "styled-components";

const Navigation = styled.nav`
    height : 100vh;
    min-width: 200px;
    padding-top: 32px;
    padding-right: 20px;
    box-shadow:5px 0px 5px #dddddd;
`

function Nav({children}) {
    return <Navigation>{children}</Navigation>
}

export default Nav;