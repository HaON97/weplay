import 'react-minimal-side-navigation/lib/ReactMinimalSideNavigation.css';
import 'semantic-ui-css/semantic.min.css';
import {Navigation} from 'react-minimal-side-navigation';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import { Icon } from 'semantic-ui-react';


const Bar = styled.div`
  position: sticky;
  top: 200px;
  width: 15%;
  height: 100%;
`;
 const SideNavbar = () => {
  const navigate = useNavigate();
    return (
      <>
        <Bar>
        <Navigation
          activeItemId="/main"
          onSelect={({ itemId }) => {
            if(itemId !== '/list'){
              navigate(itemId);
            }
          }}
          items={[
            {
              title: '메인',
              itemId: '/main',
              elemBefore: () => <Icon name="th large" style={{ fontSize: '1.2rem' }} />,
            },
            {
              title: '목록',
              itemId: '/list',
              elemBefore: () => <Icon name="tags" style={{ fontSize: '1.2rem' }} />,
              //subNav: user ? setArr : null,
              subNav: [
                {
                  title: 'Projects',
                  itemId: '/list1',
                },
                {
                  title: 'Members',
                  itemId: '/list2',
                },
              ],
            },
            {
              title: '북마크',
              itemId: '/party',
              elemBefore: () => <Icon name="bookmark" style={{ fontSize: '1.2rem' }} />,
            },
            {
              title: '읽은 목록',
              itemId: '/guild',
              elemBefore: () => <Icon name="eye" style={{ fontSize: '1.2rem' }} />,
            },
          ]}
        />
      </Bar>
    </>
    )
};

export default SideNavbar;