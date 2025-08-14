//import recusrionobj  from '../DSASheet/topicsObject';

const recusrionobj = require('./topicsObject/recursion')
try {
    function extractProblemInfo(data) {
        const result = [];
        
        // Iterate through each subcategory object in the array
        data.forEach(subcategory => {
          const subcategoryId = subcategory.subcategory_id;
          const subcategoryName = subcategory.subcategory_name;
          
          // Extract information from each problem in this subcategory
          subcategory.problems.forEach(problem => {
            result.push({
              problem_id: problem.problem_id,
              problem_name: problem.problem_name,
              subcategory_id: subcategoryId,
              subcategory_name: subcategoryName
            });
          });
        }); 
        
        return result;
      }
    
      const res = extractProblemInfo(recusrionobj);
      console.log(res);
} catch (error) {
    console.log("Err",error)
}
