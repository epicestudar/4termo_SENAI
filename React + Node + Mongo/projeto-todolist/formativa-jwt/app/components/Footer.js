// components/Footer.js
export default function Footer() {
  return (
    <footer>
      <p>&copy; 2024 My App</p>
      <style jsx>{`
        footer {
          text-align: center;
          padding: 20px;
          background-color: #333;
          color: #fff;
          position: fixed;
          width: 100%;
          bottom: 0;
        }
      `}</style>
    </footer>
  );
}
