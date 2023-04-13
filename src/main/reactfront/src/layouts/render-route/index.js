import { SideNavbar , Main} from '../common/components';
import Guild from '../guild';

const renderRoute = (props) => {
    if(props === 'main'){
        return (
            <>
                <SideNavbar/>
                <Main/>
            </>
        )
    } else if(props === 'guild'){
        return (
            <>
                <SideNavbar/>
                <Guild/>
            </>
        )
    }
}

export default renderRoute;