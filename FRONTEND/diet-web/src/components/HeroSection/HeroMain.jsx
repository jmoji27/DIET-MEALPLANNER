import React from 'react';
import { Link } from 'react-router-dom';
import HeroDiet from './HeroDiet';


const HeroMain = () => {
  return (
    <div
    id="about"
      className="min-h-screen bg-cover bg-center flex items-center"
      style={{
        backgroundImage:
          "url(https://media.istockphoto.com/id/1409236261/photo/healthy-food-healthy-eating-background-fruit-vegetable-berry-vegetarian-eating-superfood.jpg?s=612x612&w=0&k=20&c=kYZKgwsQbH_Hscl3mPRKkus0h1OPuL0TcXxZcO2Zdj0=)",
      }}
    >
      {/* Overlay for darker background */}
      <div className="absolute inset-0 bg-black bg-opacity-40 z-0"></div>

      {/* Main content over the background */}
      <div className="relative z-10 flex w-full justify-between px-8 lg:px-20 items-center">
        {/* Text on the left */}
        <div className="text-white max-w-lg">
          <h1 className="lg:text-8xl font-bold mb-6 sm:text-4xl">Diet & Mealplanning</h1>
          <p className="text-3xl font-semibold">
            We have designed this website with the 
            intent of helping people achieve their
            diet goals and create weekly meal plans.
          </p>
          
        </div>

        {/* Placeholder for right-side component */}
        <div className="bg-white-opacity-60 p-6 rounded shadow-lg max-w-2xl  w-full">
          <HeroDiet />
          <p className="text-black"></p>
        </div>
      </div>
    </div>
  );
};

export default HeroMain;


