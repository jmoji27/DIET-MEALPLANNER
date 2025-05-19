import React from "react";
import { Link } from "react-router-dom";

const HeroDiet = () => {
  return (
    <div className="w-full flex justify-center">
  <div className="w-full max-w-md space-y-4">
    {/* Title */}
    <h2 className="text-white text-center text-5xl font-bold leading-snug">
      Which of the following tags is<br />the closest to your diet goals?
    </h2>

    {/* Buttons */}
    <div className="grid grid-cols-2 gap-4">
      <Link to="/keto">
        <button className="btn btn-neutral w-full rounded-xl py-4 text-lg">Keto</button>
      </Link>
      <Link to="/lowcarb">
        <button className="btn btn-primary w-full rounded-xl py-4 text-lg">Low Carb</button>
      </Link>
      <Link to="/glutenfree">
        <button className="btn btn-secondary w-full rounded-xl py-4 text-lg">Gluten Free</button>
      </Link>
      <Link to="/paleo">
        <button className="btn btn-accent w-full rounded-xl py-4 text-lg">Paleo</button>
      </Link>
      <Link to="/vegan">
        <button className="btn btn-info w-full rounded-xl py-4 text-lg">Vegan</button>
      </Link>
      <Link to="/vegetarian">
        <button className="btn btn-success w-full rounded-xl py-4 text-lg">Vegetarian</button>
      </Link>
    </div>
  </div>
</div>

  );
};

export default HeroDiet;
