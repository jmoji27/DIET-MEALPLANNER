import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// Layout
import NavMain from "./components/navbar/NavMain";
import Footer from "./components/FooterElement/Footer";
import LoginForm from "./components/Login/LoginForm";

// Main sections
import HeroMain from "./components/HeroSection/HeroMain";
import AboutMain from "./components/About/AboutMain";
import RecipesMain from "./components/Recipes/RecipesMain";
import MealPlan from "./components/MealPlanning/MealPlan";
import SearchMain from "./components/Search/SearchMain";

// Diet pages
import Keto from "./components/Diets/Keto";
import LowCarb from "./components/Diets/LowCarb";
import GlutenFree from "./components/Diets/GlutenFree";
import Paleo from "./components/Diets/Paleo";
import Vegan from "./components/Diets/Vegan";
import Vegetarian from "./components/Diets/Vegetarian";

const App = () => {
  const [showLogin, setShowLogin] = useState(false);

  const toggleLogin = () => setShowLogin((prev) => !prev);

  return (
    <Router>
      <div className="bg-gray-900 text-white min-h-screen scroll-smooth">
        {/* Navbar */}
        <NavMain onLoginClick={toggleLogin} />

        {/* Login Modal */}
        {showLogin && (
          <div
            className="fixed inset-0 bg-black bg-opacity-40 flex justify-center items-center z-20"
            onClick={toggleLogin}
          >
            <div
              onClick={(e) => e.stopPropagation()}
              className="bg-white text-black rounded-lg p-6 shadow-lg"
            >
              <LoginForm />
            </div>
          </div>
        )}

        {/* Routes */}
        <Routes>
          <Route
            path="/"
            element={
              <div className="space-y-32 px-4">
                <HeroMain />
                <AboutMain />
                <RecipesMain />
                <SearchMain />
                <MealPlan />
              </div>
            }
          />
          <Route path="/keto" element={<Keto />} />
          <Route path="/lowcarb" element={<LowCarb />} />
          <Route path="/glutenfree" element={<GlutenFree />} />
          <Route path="/paleo" element={<Paleo />} />
          <Route path="/vegan" element={<Vegan />} />
          <Route path="/vegetarian" element={<Vegetarian />} />
        </Routes>

        {/* Footer */}
        <Footer />
      </div>
    </Router>
  );
};

export default App;
