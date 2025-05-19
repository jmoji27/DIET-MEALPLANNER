import React from "react";
import RecipesCarousel from "./RecipesCarousel";


const RecipesMain = () => {
  return (
    <div
    id="recipes"
      style={{
        backgroundImage:
          "url(https://images.unsplash.com/photo-1653611540493-b3a896319fbf?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D)",
        backgroundSize: "cover",
        backgroundPosition: "center",
      }}
      className="w-full min-h-screen py-10 px-6 lg:px-16"
    >
      {/* Title */}
      <h1 className="text-8xl font-bold text-center mb-12 text-white drop-shadow-2xl">
        Our Available Recipes
      </h1>

      {/* Two-column layout */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-10 items-start">
        {/* LEFT COLUMN — Text with border */}
        <div className="border border-slate-900 bg-black bg-opacity-60 p-6 rounded-lg shadow-lg text-white min-h-[500px]">
          <h2 className="text-7xl font-bold mb-6">Our Recipes</h2>
          <p className="text-2xl font-medium">
            Our recipes are uniquely crafted to align with each individual’s
            dietary needs and goals. Whether you're following keto, vegan,
            paleo, or just trying to eat cleaner, every recipe is thoughtfully
            designed to balance flavor, nutrition, and simplicity.
            We blend science-backed nutrition with culinary creativity to ensure that no matter your dietary path, you’ll find meals that feel personalized, satisfying, and sustainable. This isn’t just food it’s fuel, made for your journey.
          </p>
        </div>

        {/* RIGHT COLUMN — Reserved space for future component */}
        <div className=" bg-opacity-80 p-6 rounded-lg  h-full min-h-[300px]">
          {/* Placeholder for future component */}
          <h3 className="text-7xl font-bold text-center text-slate-900 mb-4">
            Most Requested Recipes
          </h3>
          <div className="  p-4 rounded min-h-[200px]">
            {/* You can insert your component here */}
             <RecipesCarousel /> 
          </div>
        </div>
      </div>
    </div>
  );
};

export default RecipesMain;
