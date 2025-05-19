import React from "react";
import { FaSearch } from "react-icons/fa";

const SearchMain = () => {
  return (
    <div id="search"
    
    className="grid grid-cols-1 lg:grid-cols-2 min-h-screen">

      {/* INGREDIENT COLUMN */}
      <div
        className="relative p-10 pr-5 text-white order-r-4 border-white"
        style={{
          backgroundImage: "url(https://media.istockphoto.com/id/1409236261/photo/healthy-food-healthy-eating-background-fruit-vegetable-berry-vegetarian-eating-superfood.jpg?s=612x612&w=0&k=20&c=kYZKgwsQbH_Hscl3mPRKkus0h1OPuL0TcXxZcO2Zdj0=)",
          backgroundSize: "cover",
          backgroundPosition: "center",
        }}
      >
        {/* Overlay */}
        <div className="absolute inset-0 bg-black bg-opacity-60 z-0"></div>

        <div className="relative z-10 space-y-6">
          <h2 className="text-6xl font-bold text-center" >Search Ingredients</h2>

          {/* Search Bar */}
          <div className="flex items-center bg-white text-black rounded-lg overflow-hidden">
            <input
              type="text"
              placeholder="Search by name..."
              className="w-full px-4 py-2 outline-none"
            />
            <button className="px-4">
              <FaSearch />
            </button>
          </div>

          {/* Filters */}
          <div className="grid grid-cols-2 gap-4 text-sm">
            <input type="number" placeholder="Min Calories" className="p-2 rounded text-black" />
            <input type="number" placeholder="Max Calories" className="p-2 rounded text-black" />
            <input type="number" placeholder="Min Protein (g)" className="p-2 rounded text-black" />
            <input type="number" placeholder="Max Carbs (g)" className="p-2 rounded text-black" />
            <input type="number" placeholder="Max Fat (g)" className="p-2 rounded text-black" />
          </div>
        </div>
      </div>
      

      {/* RECIPE COLUMN */}
      <div
        className="relative  p-8 border-l-4 border-white text-white"
        style={{
          backgroundImage: "url(https://images.unsplash.com/photo-1600891964599-f61ba0e24092)",
          backgroundSize: "cover",
          backgroundPosition: "center",
        }}
      >
        {/* Overlay */}
        <div className="absolute inset-0 bg-black bg-opacity-60 z-0"></div>

        <div className="relative z-10 space-y-6">
          <h2 className="text-6xl text-center font-bold">Search Recipes</h2>

          {/* Search Bar */}
          <div className="flex items-center bg-white text-black rounded-lg overflow-hidden">
            <input
              type="text"
              placeholder="Search by name..."
              className="w-full px-4 py-2 outline-none"
            />
            <button className="px-4">
              <FaSearch />
            </button>
          </div>

          {/* Filters */}
          <div className="grid grid-cols-2 gap-4 text-sm">
            <input type="number" placeholder="Max Calories" className="p-2 rounded text-black" />
            <select className="p-2 rounded text-black">
              <option value="">Select Diet</option>
              <option value="keto">Keto</option>
              <option value="vegan">Vegan</option>
              <option value="paleo">Paleo</option>
              <option value="vegetarian">Vegetarian</option>
              <option value="lowcarb">Low Carb</option>
              <option value="glutenfree">Gluten Free</option>

              {/* Add more diets */}
            </select>
          </div>
        </div>
      </div>

    </div>
  );
};

export default SearchMain;
