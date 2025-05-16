import React, { useState } from 'react';

const dietPlans = {
  Keto: ['Bacon & eggs', 'Avocado salad', 'Grilled salmon', 'Cheese omelette', 'Chicken thighs', 'Zucchini noodles', 'Almond pancakes'],
  Vegan: ['Smoothie bowl', 'Lentil salad', 'Tofu stir-fry', 'Chickpea curry', 'Quinoa bowl', 'Hummus wrap', 'Vegan burger'],
  Mediterranean: ['Greek yogurt', 'Hummus & veggies', 'Grilled fish', 'Tomato pasta', 'Olive salad', 'Stuffed peppers', 'Feta omelette'],
  Paleo: ['Egg muffins', 'Chicken salad', 'Beef stir-fry', 'Sweet potato hash', 'Tuna lettuce wraps', 'Fruit bowl', 'Zoodle bowl'],
//   Low-Carb: ['Scrambled eggs', 'Caesar salad', 'Grilled chicken', 'Eggplant lasagna', 'Turkey roll-ups', 'Broccoli soup', 'Cauliflower rice'],
};

const MealPlan = () => {
  const [selectedDiet, setSelectedDiet] = useState('Keto');

  return (
    <div style={styles.container}>
      <h1 style={styles.heading}>Meal Planning</h1>
      
      <select
        value={selectedDiet}
        onChange={(e) => setSelectedDiet(e.target.value)}
        style={styles.select}
      >
        {Object.keys(dietPlans).map((diet) => (
          <option key={diet} value={diet}>{diet}</option>
        ))}
      </select>

      <div style={styles.mealGrid}>
        {dietPlans[selectedDiet].map((meal, index) => (
          <div key={index} style={styles.dayBox}>
            <h4>Day {index + 1}</h4>
            <p>{meal}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

const styles = {
  container: {
    maxWidth: '800px',
    margin: '0 auto',
    padding: '40px 20px',
    textAlign: 'center',
  },
  heading: {
    marginBottom: '20px',
  },
  select: {
    padding: '10px 15px',
    fontSize: '16px',
    marginBottom: '30px',
  },
  mealGrid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fit, minmax(120px, 1fr))',
    gap: '15px',
  },
  dayBox: {
    backgroundColor: '#f2f2f2',
    padding: '15px',
    borderRadius: '8px',
    boxShadow: '0 2px 5px rgba(0,0,0,0.1)',
  }
};


export default MealPlan;