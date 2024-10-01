// components/Header.js
export default function Header() {
  return (
    <header>
      <nav>
        <ul>
          <li>
            <a href="/">Home</a>
          </li>
          <li>
            <a href="/todos">To-Do List</a>
          </li>
          <li>
            <a href="/login">Login</a>
          </li>
        </ul>
      </nav>
      <style jsx>{`
        header {
          background-color: #333;
          padding: 10px;
          color: #fff;
        }
        nav ul {
          display: flex;
          justify-content: space-around;
          list-style: none;
        }
        nav ul li {
          margin: 0 15px;
        }
        nav ul li a {
          color: white;
          text-decoration: none;
          font-weight: bold;
        }
        nav ul li a:hover {
          color: #ddd;
        }
      `}</style>
    </header>
  );
}
