import React from "react";
import "./App.css";
import Home from "./components/home";
import { Route, Routes } from "react-router-dom";
import DefaultLayout from "./components/containers/default";
import CategoryCratePage from "./components/categories/create";
import ProductListPage from "./components/products/list";
import ProductCreatePage from "./components/products/create";
import ProductEditPage from "./components/products/edit";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<DefaultLayout />}>
          <Route index element={<Home />} />
          <Route path="categories/create" element={<CategoryCratePage />} />
          <Route path="products/list" element={<ProductListPage />} />
          <Route path="products/create" element={<ProductCreatePage />} />
          <Route path="products/edit/:id" element={<ProductEditPage />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
