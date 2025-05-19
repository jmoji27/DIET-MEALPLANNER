import React from 'react'
import AboutIngredients from './AboutIngredients'

const AboutMain = () => {
  return (
   <div id="ingredients"
   style={{ backgroundColor: "#1E222A" }}
   
   className="w-full min-h-screen  py-10 px-6 lg:px-16 ">
  {/* Title */}
  <h1 className="text-8xl font-bold text-center mb-12 text-white">
    Our Supported Ingredients
  </h1>

  {/* Two-column layout */}
  <div className="grid grid-cols-1 lg:grid-cols-2 gap-10 items-start">
    {/* Left column (Text + Image) */}
    <div className="bg-white p-6 rounded-lg shadow-lg">
      <h3 
      style={{ color: "#1E222A" }}
      
      className="text-3xl font-bold mb-4 text-center">Ingredients Table</h3>
      <div className="border border-gray-200 p-4 rounded">
        {/* Example table placeholder */}
        <AboutIngredients />
        </div>
      
    </div>

    {/* Right column (Table component placeholder) */}
   <div className="space-y-6">
      <h2 className="text-6xl font-bold text-white"> About Our Ingredients</h2>
      <p className="text-white text-2xl font-semibold">
        All of our Ingredients are measured in 100g with the exception of those 
        Ingredients that tend to be quantities, as an example we dont measure eggs in 100g but as a unit.
        Shredded Cheese however as an example would be measured in 100g.
      </p>
      <img
        src="https://images.unsplash.com/photo-1512621776951-a57141f2eefd"
        alt="Healthy Food"
        className="rounded-lg shadow-md w-full max-h-96 object-cover"
      />
    </div>
  </div>
  </div>



  )
}

export default AboutMain