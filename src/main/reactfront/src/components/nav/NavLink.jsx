import styled, { css } from "styled-components";

function isCurrent(to) {
  return window.location.pathname.startsWith(to);
}

const Link = styled.a`
  display: block;
  margin: 0 calc(20px * -1);
  padding: 8px 20px;
  border-radius: 4px;
  color: #888888;
  text-decoration: none;
  background:white;

  ${(p) =>
    p.active &&
    css`
      color: #888888;
      font-weight: bold;
    `}

  &:hover {
    background: #ff8906;
    color: #dddddd;
    transform: translateY(-2px);
    transition: 1s;
  }

  &:not([href]) {
    color: #a7a9be;
    background: revert;
    transform: none;
  }
`;

function NavLink({ children, to, active = false }) {
  return (
    <Link
      href={to}
      active={active}
      aria-current={isCurrent(to) ? "page" : null}
    >
      {children}
    </Link>
  );
}

export default NavLink;
