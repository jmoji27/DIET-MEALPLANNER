import React from "react";

const listItems = [
  { name: "Home", id: "about" },
  { name : "Ingredients", id: "ingredients"},
  { name: "Recipes", id: "recipes" },
  { name: "Meal Planning", id: "mealplanning" },
  { name: "Search", id: "search" }, 
];

const NavMain = ({ onLoginClick }) => {
  return (
    <nav className="fixed top-0 left-0 w-full bg-[#111827] text-white shadow-lg z-50">
      <div className="max-w-7xl mx-auto flex justify-between items-center px-10 py-5">
        {/* Navigation Items */}
        <ul className="flex gap-14 text-xl font-semibold tracking-wide">
          {listItems.map((item) => (
            <li key={item.id} className="relative group cursor-pointer">
              <a
                href={`#${item.id}`}
                className="px-4 py-2 hover:text-green-400 transition-colors duration-300 rounded-md"
              >
                {item.name}
              </a>
              <span className="absolute left-0 bottom-0 w-0 h-[2px] bg-green-400 transition-all duration-300 group-hover:w-full rounded"></span>
            </li>
          ))}
        </ul>

        {/* Login Button */}
        <button
          onClick={onLoginClick}
          className="px-8 py-3 bg-white text-black text-lg font-semibold rounded-md shadow-md hover:bg-gray-100 transition-all duration-200"
        >
          Log In
        </button>
      </div>
    </nav>
  );
};

export default NavMain;
