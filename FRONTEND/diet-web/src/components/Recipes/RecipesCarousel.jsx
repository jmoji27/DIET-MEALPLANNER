import React, { useState } from "react";
import { FaChevronLeft, FaChevronRight } from "react-icons/fa";

const sampleRecipes = [
  {
    id: 1,
    name: "Avocado Toast",
    dietId: 101,
    instructions: "Toast bread. Slice avocado. Spread and sprinkle salt. Done!",
  },
  {
    id: 2,
    name: "Grilled Chicken Bowl",
    dietId: 102,
    instructions: "Grill chicken. Cook rice. Combine with veggies and top with sauce.",
  },
  {
    id: 3,
    name: "Vegan Stir Fry",
    dietId: 103,
    instructions: "Stir-fry tofu with vegetables. Add soy sauce and serve over rice.",
  },
  {
    id: 4,
    name: "Salmon Quinoa",
    dietId: 104,
    instructions: "Grill salmon. Cook quinoa. Serve with lemon and greens.",
  },
];

const RecipesCarousel = () => {
  const [current, setCurrent] = useState(0);

  const next = () => {
    setCurrent((prev) => (prev + 1) % sampleRecipes.length);
  };

  const prev = () => {
    setCurrent((prev) =>
      prev === 0 ? sampleRecipes.length - 1 : prev - 1
    );
  };

  const recipe = sampleRecipes[current];

  return (
    <div className="relative max-w-md mx-auto bg-white text-black border border-gray-400 p-6 rounded-lg shadow-xl font-mono min-h-[350px]">
      <h2 className="text-2xl font-bold border-b-2 border-black mb-4 pb-2">
        {recipe.name.toUpperCase()}
      </h2>

      <div className="text-sm space-y-4">
        <div>
          <strong>Instructions:</strong>
          <p className="mt-1 whitespace-pre-wrap">{recipe.instructions}</p>
        </div>
        <div className="text-xs text-gray-600">
          <span className="italic">Diet ID: {recipe.dietId}</span>
        </div>
      </div>

      {/* Navigation Buttons */}
      <div className="flex justify-between mt-6">
        <button
          onClick={prev}
          className="bg-slate-800 text-white px-3 py-1 rounded hover:bg-slate-700"
        >
          <FaChevronLeft />
        </button>
        <button
          onClick={next}
          className="bg-slate-800 text-white px-3 py-1 rounded hover:bg-slate-700"
        >
          <FaChevronRight />
        </button>
      </div>
    </div>
  );
};

export default RecipesCarousel;
