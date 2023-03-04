import React from "react";
import "./App.css";
import Home from "./components/home";
import { Route, Routes } from "react-router-dom";
import DefaultLayout from "./components/containers/default";
import CategoryCratePage from "./components/categories/create";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<DefaultLayout />}>
          <Route index element={<Home />} />
          <Route path="categories/create" element={<CategoryCratePage />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
