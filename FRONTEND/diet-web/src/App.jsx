
import NavMain from "./components/navbar/NavMain";
import LoginForm from "./components/Login/LoginForm";
import React, { useState } from "react";
import MealPlan from "./components/MealPlanning/MealPlan";
import Footer from "./components/FooterElement/Footer";
import UserMeal from "./components/User/UserMeal";
import IngredientForm from "./components/Admin/IngredientForm";
import MealPlanner from "./components/MealPlanning/MealPlanner";
import HeroMain from "./components/HeroSection/HeroMain";
import AboutMain from "./components/About/AboutMain";
const App = () => {
  const [showLogin, setShowLogin] = useState(false);

  const toggleLogin = () => {
    setShowLogin((prev) => !prev);
  };

  return (
    <div>
      <div>
      <NavMain onLoginClick={toggleLogin} />

{showLogin && (
  <div
    className="fixed inset-0 bg-black bg-opacity-40 flex justify-center items-center z-20"
    onClick={toggleLogin}
  >
    <div onClick={(e) => e.stopPropagation()} className="bg-white rounded-lg p-6 shadow-lg">
      <LoginForm />
    </div>
  </div>
)}

      </div>

      <div>
      <HeroMain />
      <AboutMain />
      <div className="mt-32 px-4">
        <MealPlan /> 
      </div>
      

      <UserMeal/>
      <IngredientForm/>
      <MealPlanner/>


    <Footer />

      </div>
      
     
    </div>
   
  );
};

export default App;

