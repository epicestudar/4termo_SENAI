import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import LivroForm from "./components/LivroForm";
import "./App.css";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/novo-livro" element={<LivroForm />} />
        <Route path="/editar-livro/:id" element={<LivroForm />} />
      </Routes>
    </Router>
  );
}

export default App;
