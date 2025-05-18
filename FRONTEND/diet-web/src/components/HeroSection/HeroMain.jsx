import React from 'react';
import HeroDiet from './HeroDiet';
import { Link } from 'react-router-dom';


const HeroMain = () => {
  return (
    <div
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
          <h1 className="text-5xl font-bold mb-6">Hello there</h1>
          <p className="mb-6">
            Provident cupiditate voluptatem et in. Quaerat fugiat ut assumenda excepturi exercitationem
            quasi. In deleniti eaque aut repudiandae et a id nisi.
          </p>
          <button className="btn btn-primary">Get Started</button>
        </div>

        {/* Placeholder for right-side component */}
        <div className="bg-white p-6 rounded shadow-lg max-w-md w-full">
          {/* Replace this with your component */}
          <p className="text-black"></p>
        </div>
      </div>
    </div>
  );
};

export default HeroMain;


