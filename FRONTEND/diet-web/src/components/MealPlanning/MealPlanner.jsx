import React from "react";
import { useState } from "react";

const MealPlanner = ({ userId }) => {
    const [meal, setMeal] = useState({
      date: "",
      mealType: "",
      recipeId: ""
    });
  
    // const handleSubmit = async () => {
    //   await axios.post("http://localhost:8080/api/plan/add", {
    //     ...meal,
    //     userId: userId, // from login/JWT/localStorage
    //   });
    //   alert("Meal added!");
    // };
  
    return (
      <div>
        {/* <input type="date" onChange={e => setMeal({ ...meal, date: e.target.value })} /> */}
        <select onChange={e => setMeal({ ...meal, mealType: e.target.value })}>
          <option>Breakfast</option>
          <option>Lunch</option>
          <option>Dinner</option>
        </select>
        <select onChange={e => setMeal({ ...meal, recipeId: e.target.value })}>
          <option value="1">Nasi Kuning</option>
          <option value="2">Pho Ga</option>
        </select>
        {/* <button onClick={handleSubmit}>Add to Plan</button> */}
      </div>
    );
  };
  export default MealPlanner;