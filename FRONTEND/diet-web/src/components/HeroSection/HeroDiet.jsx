import React from 'react';
import { Link } from 'react-router-dom';

const diets = [
  { name: 'Keto', color: 'bg-red-400', path: '/diets/keto' },
  { name: 'Vegan', color: 'bg-green-400', path: '/diets/vegan' },
  { name: 'Low Carb', color: 'bg-blue-400', path: '/diets/low-carb' },
  { name: 'Gluten-Free', color: 'bg-yellow-400', path: '/diets/gluten-free' },
  { name: 'Vegetarian', color: 'bg-purple-400', path: '/diets/vegetarian' },
  { name: 'Paleo', color: 'bg-pink-400', path: '/diets/paleo' },
];

const Bubble = ({ name, color, path }) => (
  <Link
    to={path}
    className={`rounded-full w-24 h-24 md:w-28 md:h-28 flex items-center justify-center text-white font-semibold text-center shadow-md hover:scale-110 transition-transform duration-300 ${color}`}
  >
    {name}
  </Link>
);

const HeroDiet = () => {
  return (
    <div className="flex flex-col items-center gap-6">
      {/* Top row: 2 buttons */}
      <div className="flex gap-8">
        <Bubble {...diets[0]} />
        <Bubble {...diets[1]} />
      </div>

      {/* Middle row: 3 buttons */}
      <div className="flex gap-8">
        <Bubble {...diets[2]} />
        <Bubble {...diets[3]} />
        <Bubble {...diets[4]} />
      </div>

      {/* Bottom row: 1 button */}
      <div>
        <Bubble {...diets[5]} />
      </div>
    </div>
  );
};

export default HeroDiet;
