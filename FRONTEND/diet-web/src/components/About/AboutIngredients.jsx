import React from 'react'

const AboutIngredients = () => {
  const placeholderRows = Array.from({ length: 1000 }, (_, i) => ({
    name: `Ingredient ${i + 1}`,
    calories: "-",
    carbs: "-",
    fats: "-",
    protein: "-",
  }));

  return (
    <div className="overflow-x-auto">
      <div className="max-h-[600px] overflow-y-auto border rounded-lg shadow-md">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-100 sticky top-0 z-10">
            <tr>
              <th className="px-4 py-3 text-left text-sm font-medium text-gray-700">Name</th>
              <th className="px-4 py-3 text-left text-sm font-medium text-gray-700">Calories</th>
              <th className="px-4 py-3 text-left text-sm font-medium text-gray-700">Carbs (g)</th>
              <th className="px-4 py-3 text-left text-sm font-medium text-gray-700">Fats (g)</th>
              <th className="px-4 py-3 text-left text-sm font-medium text-gray-700">Protein (g)</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-100">
            {placeholderRows.map((item, index) => (
              <tr key={index} className="hover:bg-gray-50">
                <td className="px-4 py-2">{item.name}</td>
                <td className="px-4 py-2">{item.calories}</td>
                <td className="px-4 py-2">{item.carbs}</td>
                <td className="px-4 py-2">{item.fats}</td>
                <td className="px-4 py-2">{item.protein}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default AboutIngredients
