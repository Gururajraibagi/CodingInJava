export const recusrionobj =[
    {
      "subcategory_id": "recursion_implementation",
      "subcategory_name": "Implementation Problems",
      "subcategory_slug": "implementation-problems",
      "subcategory_rank": 1,
      "subcategory_type": "study",
      "problems": [
        {
          "problem_id": "recursion_recursion_implementation_pow(x,n)",
          "problem_name": "Pow(x,n)",
          "problem_slug": "pow(x,n)",
          "problem_rank": 1,
          "misc": {
            "tags": [
              "Shopify",
              "Siemens Healthineers",
              "PwC",
              "Ubisoft",
              "Bloomberg",
              "Zynga",
              "Cloudflare",
              "Deloitte",
              "GE Healthcare",
              "Philips Healthcare",
              "Goldman Sachs",
              "Robinhood",
              "Zomato",
              "Roche",
              "Medtronic",
              "Chewy",
              "Western Digital",
              "Cerner",
              "Salesforce",
              "Etsy",
              "Databricks",
              "Square",
              "DoorDash",
              "Morgan Stanley",
              "Splunk",
              "TCS",
              "Cognizant",
              "Accenture",
              "Infosys",
              "Capgemini",
              "Wipro"
            ],
            "facts": "In Google's search algorithm, the concept of power function comes into play. This algorithm named PageRank, uses power iteration methodology to calculate the ranks of pages. The basic idea is to count the number and quality of links to a page to determine a rough estimate of how important the page is. The underlying assumption is that more important pages are likely to receive more links from other websites. Thus, a mathematically defined multiple number of iterations (x raised to n) helps in providing more precise page rankings.",
            "hints": [
              {
                "hint": "Use Exponentiation by Squaring, which reduces the time complexity to O(logn)"
              },
              {
                "hint": "\"Iterative: Avoids stack overflow and is more memory-efficient (O(1) space). Recursive: Cleaner and simpler code, but uses O(logn) space due to recursion.\""
              }
            ],
            "language": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [
              {
                "answer": "For negative n, the result is 1/x^−n. Compute x−n as if n were positive, then take the reciprocal.",
                "question": "What happens if n<0?"
              },
              {
                "answer": "Iterative implementation uses constant space (O(1)) and avoids stack overflow for large n. This makes it more robust for competitive programming scenarios.\n",
                "question": "Why is iterative implementation preferred in competitive programming?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Use the formula ((amodm)⋅(bmodm))modm at each step to keep intermediate results within bounds.\nModular exponentiation is widely used in cryptography and number theory.",
                "question": "How would you modify this algorithm for modular exponentiation ((x^n)modm)?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_implementation_generateparanthesis",
          "problem_name": "Generate Paranthesis",
          "problem_slug": "generate-paranthesis",
          "problem_rank": 2,
          "misc": {
            "tags": [
              "Reddit",
              "Texas Instruments",
              "DoorDash",
              "Lyft",
              "Philips Healthcare",
              "PayPal",
              "Splunk",
              "Rakuten",
              "Zomato",
              "Etsy",
              "Walmart",
              "American Express",
              "Flipkart",
              "Stripe",
              "KPMG",
              "Siemens Healthineers",
              "Zoho",
              "Intel",
              "Uber",
              "Epic Systems",
              "Unity Technologies",
              "Boston Consulting Group",
              "Bungie",
              "Cerner",
              "Freshworks",
              "TCS",
              "Cognizant",
              "Accenture",
              "Infosys",
              "Capgemini",
              "Wipro"
            ],
            "facts": "Fun Fact: The concept behind well-formed parentheses is key in developing various software tools, especially in language parsing libraries and compilers. Programmers often deal with nested structures like functions, loops, and conditionals in coding, which are represented using parentheses, braces, etc. The formation or validation of these correctly structured parentheses and other symbols is of utmost importance for the correct interpretation of the code. Similarly, tools for checking the validity of XML or JSON also use this concept to ensure the correct pairing and nesting of tags and braces.",
            "hints": [
              {
                "hint": "Start with an empty string and keep adding ( or ) recursively. If the string has 2×n characters, add it to the result."
              },
              {
                "hint": "Use a backtracking approach where you explore all possibilities and backtrack when the current combination is invalid."
              }
            ],
            "language": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [
              {
                "answer": "Use two counters to track the number of ( and ) added:\nAdd ( only if ( count < n.\nAdd ) only if ) count < ( count.",
                "question": "How do you ensure that the combinations are valid?"
              },
              {
                "answer": "The base case is when the length of the current combination reaches 2×n. At this point, the combination is added to the result list.",
                "question": "What is the base case for recursion?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Yes, use a stack to simulate the backtracking process. Push intermediate states onto the stack and pop them as you explore combinations.",
                "question": "Can this problem be solved iteratively instead of recursively?"
              },
              {
                "answer": "Modify the algorithm to handle multiple types of brackets. Track counts for each type separately and ensure valid nesting.",
                "question": "How would you extend this for other types of brackets (e.g., {}, [])?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_implementation_powerset",
          "problem_name": "Power Set",
          "problem_slug": "power-set",
          "problem_rank": 3,
          "misc": {
            "tags": [
              "Wayfair",
              "Dropbox",
              "Red Hat",
              "Swiggy",
              "Bain & Company",
              "Roche",
              "Zynga",
              "Nutanix",
              "Morgan Stanley",
              "Freshworks",
              "Visa",
              "MongoDB",
              "Seagate Technology",
              "Bloomberg",
              "Bungie",
              "Optum",
              "Boston Consulting Group",
              "Micron Technology",
              "Splunk",
              "HCL Technologies",
              "Activision Blizzard",
              "DoorDash",
              "Philips Healthcare",
              "Riot Games",
              "JPMorgan Chase",
              "TCS",
              "Cognizant",
              "Accenture",
              "Infosys",
              "Capgemini",
              "Wipro"
            ],
            "facts": "The problem of finding all possible subsets from a set, also known as the power set, is an important concept in many areas of software development. In database technologies, such as SQL, this concept is used in designing queries that require combinations of data, such as generating all combinations of products that can be bundled together. In Machine Learning, power sets are used in feature selection, where combinations of different features are tested to see which set gives the best predictive accuracy. Meanwhile in Software Testing, generating all possible subsets of a feature set aids in creating exhaustive test cases which helps find potential bugs or issues.",
            "hints": [
              {
                "hint": "Use recursion to build subsets by deciding for each element whether to include it in the current subset."
              },
              {
                "hint": "\"At each recursive step: Add the current subset to the result. Recursively add subsets including the next element.\""
              }
            ],
            "language": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [
              {
                "answer": "The problem guarantees that nums contains unique elements, so duplicates will not arise during subset generation.",
                "question": "How do you ensure no duplicates are included?"
              },
              {
                "answer": "The order of elements in subsets follows the input array's order. If specific ordering is required, sort the array before generating subsets.",
                "question": "How do subsets handle ordering?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Use a backtracking approach with a constraint that the subset's size equals k.",
                "question": "How would you modify this to generate subsets of a fixed size k?"
              },
              {
                "answer": "Sort the array first, then skip duplicate elements during subset generation to avoid redundant subsets. This ensures unique combinations.",
                "question": "What if duplicates are allowed in the input array?"
              },
              {
                "answer": "Represent subsets using binary strings, where each bit indicates whether an element is included. This is useful in optimization problems where subsets must be encoded compactly.",
                "question": "What are alternative representations of subsets?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    },
    {
      "subcategory_id": "recursion_subsequencepatternproblems",
      "subcategory_name": "Subsequence Pattern Problems",
      "subcategory_slug": "subsequence-pattern-problems",
      "subcategory_rank": 2,
      "subcategory_type": "study",
      "problems": [
        {
          "problem_id": "recursion_recursion_subsequencepatternproblems_countallsubsequenceswithsumk",
          "problem_name": "Count all subsequences with sum K",
          "problem_slug": "count-all-subsequences-with-sum-k",
          "problem_rank": 2,
          "misc": {
            "tags": [
              "Teladoc Health",
              "Roblox",
              "Airbnb",
              "Rockstar Games",
              "MongoDB",
              "OYO Rooms",
              "Oracle",
              "Boston Consulting Group",
              "DoorDash",
              "Optum",
              "Rakuten",
              "Snowflake",
              "Databricks",
              "Bain & Company",
              "Shopify",
              "Square",
              "Byju's",
              "Chewy",
              "Cloudflare",
              "Riot Games",
              "Bungie",
              "AMD",
              "Lyft",
              "Stripe",
              "PayPal",
              "TCS",
              "Cognizant",
              "Accenture",
              "Infosys",
              "Capgemini",
              "Wipro"
            ],
            "facts": "Fun Fact: The \"sum of subsequence equals K\" problem concept has a broad range of applications. It is primarily used in financial software for portfolio optimization and risk management. For example, an investor may want to find all combinations of stocks (subsequences from an array of available stocks) that result in a specific target return (sum equals to K). Optimizing and streamlining this process can result in substantial investment efficiency. It is also used in budgeting apps for determining possible allocations of available resources to achieve a financial goal.",
            "hints": [
              {
                "hint": "Use a boolean DP array dp where dp[j] represents whether a subset with sum j can be formed."
              },
              {
                "hint": "\"Recursively explore all combinations of elements: Either include the current element in the subset or skip it. If the sum equals k at any point, return True.\""
              }
            ],
            "language": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [
              {
                "answer": "The DP array tracks all possible subset sums that can be formed using elements seen so far. If dp[k] is True, it means a subset with sum k exists.",
                "question": "How does the DP array work?"
              },
              {
                "answer": "If k>sum(nums), it is impossible to find a subset with sum k. The algorithm naturally returns False in such cases.",
                "question": "What happens if k is larger than the sum of nums?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Use backtracking to generate all subsets, and collect those with a sum of k. This can be more computationally intensive than checking for existence.",
                "question": "How would you modify this to find all subsets with sum k?"
              },
              {
                "answer": "Flatten the array and apply the same logic. For multi-dimensional constraints, modify the DP approach to include more states.",
                "question": "Can this be extended to multi-dimensional arrays?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_subsequencepatternproblems_checkifthereexistsasubsequencewithsumk",
          "problem_name": "Check if there exists a subsequence with sum K",
          "problem_slug": "check-if-there-exists-a-subsequence-with-sum-k",
          "problem_rank": 2,
          "misc": {
            "tags": [
              "JPMorgan Chase",
              "Intel",
              "MongoDB",
              "Bain & Company",
              "IBM",
              "Epic Systems",
              "Wayfair",
              "Databricks",
              "Boston Consulting Group",
              "Docker",
              "Epic Games",
              "Micron Technology",
              "Roche",
              "Robinhood",
              "Unity Technologies",
              "Activision Blizzard",
              "Visa",
              "Optum",
              "Stripe",
              "Bloomberg",
              "Twilio",
              "DoorDash",
              "Freshworks",
              "Byju's",
              "AMD",
              "TCS",
              "Cognizant",
              "Accenture",
              "Infosys",
              "Capgemini",
              "Wipro"
            ],
            "facts": "Fun Fact: Checking if a subsequence sums to a given value is a core problem in the development of financial software, particularly in portfolio management and risk analysis. By defining \"nums\" as investment returns and \"k\" as a desired return, this approach can help determine potential combinations of investments that could achieve a particular financial goal. Similarly, it's also used in encryption and decoding algorithms in cyber security, which is quite imperative for maintaining data integrity and confidentiality.",
            "hints": [
              {
                "hint": "Explore all possible subsequences recursively and count the valid ones where the sum equals k. Use a DP table where dp[j] represents the number of subsequences with sum j."
              },
              {
                "hint": "Use recursion to explore all subsequences:Count the number of valid subsequences where the sum equals k."
              }
            ],
            "language": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [
              {
                "answer": "The DP table tracks how many subsequences can form a specific sum. For each element num, it updates possible sums to include subsequences containing num.",
                "question": "How does the DP table work?"
              },
              {
                "answer": "If k is greater than the sum of all elements in nums, return 0 immediately, as no subsequence can achieve that sum.",
                "question": "What if k>sum(nums)?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the DP array or backtracking condition to include sums within the tolerance range.",
                "question": "How would you handle approximate sums (e.g., ∣sum−k∣≤tolerance)?"
              },
              {
                "answer": "Use backtracking to collect all subsequences with sum k. Append valid subsequences to a result list instead of just counting them.",
                "question": "How would you modify this to return the subsequences instead of the count?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    },
    {
      "subcategory_id": "recursion_faqs",
      "subcategory_name": "FAQs (Medium)",
      "subcategory_slug": "faqs-medium",
      "subcategory_rank": 3,
      "subcategory_type": "study",
      "problems": [
        {
          "problem_id": "recursion_recursion_faqs_combinationsum",
          "problem_name": "Combination Sum",
          "problem_slug": "combination-sum",
          "problem_rank": 1,
          "misc": {
            "tags": [
              "JPMorgan Chase",
              "Mastercard",
              "Cerner",
              "Broadcom",
              "PayPal",
              "Shopify",
              "Snowflake",
              "Walmart",
              "Intel",
              "Boston Consulting Group",
              "Stripe",
              "Dropbox",
              "Philips Healthcare",
              "Morgan Stanley",
              "KPMG",
              "Byju's",
              "Unity Technologies",
              "Databricks",
              "Visa",
              "Pinterest",
              "Robinhood",
              "Ubisoft",
              "Wayfair",
              "Optum",
              "Goldman Sachs",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "This problem is a classic demonstration of combinatorial search and dynamic programming, and it's often encountered in real-world scenarios, especially in e-commerce and budgeting-oriented applications. For example, given a budget, we might want to find all combinations of products (represented by their prices) that would total up to the budget. The problem also relates to other cases such as coin change problems, which are popular in coding interviews, and are used behind the scenes in ATM and cash transactions, to provide the fewest possible number of coins or bills.",
            "hints": [
              {
                "hint": "Use recursion to explore all combinations of numbers: Include the current number and subtract it from the target. Skip the current number and move to the next candidate."
              },
              {
                "hint": "Start each recursive call with the current index to avoid revisiting previous elements and prevent duplicate combinations."
              }
            ],
            "language": [],
            "difficulty": "Medium",
            "frequently_occuring_doubts": [
              {
                "answer": "In backtracking, allow the recursive call to revisit the same index to include the current candidate multiple times. Move to the next index only when the candidate is skipped.",
                "question": "How do you handle unlimited usage of a candidate?"
              },
              {
                "answer": "Sorting ensures that candidates are processed in ascending order. This allows early termination of branches when the target becomes smaller than the current candidate.",
                "question": "How does sorting the candidates help?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the recursive function to move to the next index after including the current candidate. This prevents reusing a candidate multiple times.",
                "question": "What if candidates can only be used once?"
              },
              {
                "answer": "For large targets, reduce the problem size using memoization to cache results for previously computed targets. This avoids redundant computations.",
                "question": "How would you handle large values of target?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs_combinationsumii",
          "problem_name": "Combination Sum II",
          "problem_slug": "combination-sum-ii",
          "problem_rank": 2,
          "misc": {
            "tags": [
              "Cerner",
              "Broadcom",
              "American Express",
              "Epic Systems",
              "Teladoc Health",
              "eBay",
              "NVIDIA",
              "Bain & Company",
              "Uber",
              "Western Digital",
              "Snowflake",
              "DoorDash",
              "Morgan Stanley",
              "Stripe",
              "Lyft",
              "HashiCorp",
              "Red Hat",
              "Instacart",
              "Splunk",
              "Chewy",
              "IBM",
              "Philips Healthcare",
              "Roblox",
              "MongoDB",
              "JPMorgan Chase",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "This problem can be framed as a subset sum problem, which has a wide range of applications in the software industry, particularly in financial technology (fintech) and inventory management systems. For example, in a stock trading application, an algorithm might need to find combinations of stocks that add up to a user's specified budget. Similarly, in inventory management, it could assist in finding combinations of items to fulfill a certain order, given constraints such as weight or cost.",
            "hints": [
              {
                "hint": "Use recursion to explore all possible combinations. Stop when the target becomes zero (a valid combination is found) or when the target becomes negative (discard the branch)."
              },
              {
                "hint": "\"Sort the input array candidates to handle duplicates easily. Skip duplicates during recursion: If candidates[i]==candidates[i-1] and i>start, skip the current element.\""
              }
            ],
            "language": [],
            "difficulty": "Medium",
            "frequently_occuring_doubts": [
              {
                "answer": "Sorting simplifies duplicate handling and ensures that combinations are generated in lexicographical order.",
                "question": "Why sort the candidates array?"
              },
              {
                "answer": "Sorting candidates before recursion ensures that combinations are generated in ascending order.",
                "question": "How is the order of output combinations ensured?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the recursion to allow revisiting the same index instead of moving to the next index after including a number.",
                "question": "What if candidates can be used multiple times?"
              },
              {
                "answer": "Instead of storing valid combinations, maintain a counter to track the number of valid combinations found.",
                "question": "How would you modify this to return the number of unique combinations instead of the combinations themselves?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs_subsetsi",
          "problem_name": "Subsets I",
          "problem_slug": "subsets-i",
          "problem_rank": 3,
          "misc": {
            "tags": [
              "Docker",
              "Bloomberg",
              "Texas Instruments",
              "Seagate Technology",
              "Red Hat",
              "Bungie",
              "Epic Games",
              "Zomato",
              "Splunk",
              "Walmart",
              "Wayfair",
              "Cloudflare",
              "Boston Consulting Group",
              "HashiCorp",
              "Ubisoft",
              "Robinhood",
              "Snowflake",
              "Ernst & Young",
              "Rakuten",
              "Optum",
              "Instacart",
              "Unity Technologies",
              "Flipkart",
              "Teladoc Health",
              "Uber",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "This problem is actually a fundamental concept in business analytics and Big Data processing. Whenever companies perform market basket analysis (eg supermarket transaction data to find the association between different item sets) or power set calculations, this function for calculating the sum of all subsets can be heavily used. Having optimized algorithms to solve this problem can greatly improve the efficiency of processing large datasets. This subset sum problem is also related to cryptography, operations research, and complexity theory, all essential concepts in software industry.",
            "hints": [
              {
                "hint": "\"Each element in nums contributes to exactly half of the subsets because every element either appears or doesn't appear in any given subset. For an element x in nums, it contributes x×2^n−1 to the total sum, where n is the size of the array.\""
              },
              {
                "hint": "Generate all subsets of nums and compute their sums individually."
              }
            ],
            "language": [],
            "difficulty": "Medium",
            "frequently_occuring_doubts": [
              {
                "answer": "Generating all subsets is computationally expensive for large n. Optimizing using the 2^n−1 contribution rule avoids this.",
                "question": "Why not generate all subsets explicitly?"
              },
              {
                "answer": "In a set of size n, each element appears in exactly half of the 2^n subsets because subsets either include or exclude the element.",
                "question": "How does each element contribute to 2^n−1 subsets?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Use backtracking or bit masking to generate subsets and compute their sums. This may be required in specific scenarios where all subsets are needed.",
                "question": "What if subsets must be generated explicitly?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs_subsetsii",
          "problem_name": "Subsets II",
          "problem_slug": "subsets-ii",
          "problem_rank": 4,
          "misc": {
            "tags": [
              "Goldman Sachs",
              "OYO Rooms",
              "Optum",
              "Chewy",
              "Zomato",
              "Etsy",
              "Salesforce",
              "Rockstar Games",
              "Flipkart",
              "Stripe",
              "Electronic Arts",
              "Uber",
              "Deloitte",
              "Rakuten",
              "Freshworks",
              "Zoho",
              "Intel",
              "Oracle",
              "Bungie",
              "Walmart",
              "Roblox",
              "Zynga",
              "HCL Technologies",
              "AMD",
              "Databricks",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "The underlying concept of the problem statement - power set - has real-world applications in a lot of areas within software development. An interesting fact is in the recommendation engines you interact with every day when you use platforms like Netflix or Amazon. These recommendation systems often use the concept of power sets in their algorithms to generate combinations of items (for instance, movies or products) that a user may be interested in based on their previous behavior. The concept of power sets, thus, plays a significant role in building personalized user experience across many applications.",
            "hints": [
              {
                "hint": "Sort the input array nums to group duplicate elements together. While generating subsets, skip duplicate elements to avoid generating the same subset multiple times"
              },
              {
                "hint": "Start with an empty subset. For each element in nums, add it to all existing subsets. To handle duplicates, only extend subsets created in the previous iteration for duplicate elements."
              }
            ],
            "language": [],
            "difficulty": "Medium",
            "frequently_occuring_doubts": [
              {
                "answer": "By skipping duplicate elements during recursion or tracking subsets generated in the last step during iteration, the algorithm avoids duplicate subsets.",
                "question": "How does the solution ensure subsets are unique?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Use combinations from the itertools library or modify the backtracking approach to include a size constraint.",
                "question": "What if subsets of a specific size k are required?"
              },
              {
                "answer": "Sorting simplifies the process of skipping duplicates, but you can use a hash set to track generated subsets and ensure uniqueness without sorting.",
                "question": "Can this problem be solved without sorting the array?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs_combinationsumiii",
          "problem_name": "Combination Sum III",
          "problem_slug": "combination-sum-iii",
          "problem_rank": 5,
          "misc": {
            "tags": [
              "GE Healthcare",
              "Lyft",
              "Medtronic",
              "Nutanix",
              "Byju's",
              "Morgan Stanley",
              "Johnson & Johnson",
              "IBM",
              "Mastercard",
              "DoorDash",
              "Texas Instruments",
              "ARM",
              "NVIDIA",
              "Freshworks",
              "Airbnb",
              "Alibaba",
              "MongoDB",
              "Riot Games",
              "Electronic Arts",
              "eBay",
              "Zynga",
              "Unity Technologies",
              "HashiCorp",
              "Cerner",
              "Zomato",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "Fun Fact: This problem is a variant of the classic combinatorial problem in computer science often encountered in financial software, where an organization might want to understand all possible combinations of assets that can achieve a given financial target. Beyond finance, it also broadly applies in decision-making algorithms, such as in Artificial Intelligence for exploring all potential paths or actions. By enumerating all possibilities, the software can make more informed decisions to achieve the desired goal.",
            "hints": [
              {
                "hint": "\"Use recursion to explore combinations. Include a number from 1 to 9 and reduce both n (target sum) and k (remaining numbers to select). Exclude the current number and move to the next.\""
              },
              {
                "hint": "Generate combinations by iterating through numbers from the current index to ensure each number is used only once. This avoids generating duplicate combinations."
              }
            ],
            "language": [],
            "difficulty": "Medium",
            "frequently_occuring_doubts": [
              {
                "answer": "By iterating from the current number onwards and avoiding revisits, duplicate combinations like [2,3] and [3,2] are naturally avoided.",
                "question": "How do you ensure combinations are unique?"
              },
              {
                "answer": "Brute force involves generating all subsets of size k and checking their sum, which is inefficient. Backtracking avoids unnecessary computations by pruning invalid branches early.",
                "question": "Why not use brute force to generate all subsets?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the recursion to allow revisiting the same number. Start recursive calls from the current number instead of the next number.",
                "question": "What if numbers can be reused?"
              },
              {
                "answer": "Use memoization to store intermediate results for previously computed states to avoid redundant calculations.",
                "question": "How would you handle very large n and k?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    },
    {
      "subcategory_id": "recursion_hard",
      "subcategory_name": "Hard",
      "subcategory_slug": "hard",
      "subcategory_rank": 4,
      "subcategory_type": "study",
      "problems": [
        {
          "problem_id": "recursion_recursion_hard_lettercombinationsofaphonenumber",
          "problem_name": "Letter Combinations of a Phone Number",
          "problem_slug": "letter-combinations-of-a-phone-number",
          "problem_rank": 1,
          "misc": {
            "tags": [
              "Stripe",
              "HCL Technologies",
              "IBM",
              "Goldman Sachs",
              "Boston Consulting Group",
              "Broadcom",
              "Dropbox",
              "Epic Systems",
              "Cerner",
              "Flipkart",
              "Ernst & Young",
              "Epic Games",
              "Chewy",
              "HashiCorp",
              "Qualcomm",
              "Square",
              "Morgan Stanley",
              "MongoDB",
              "Micron Technology",
              "OYO Rooms",
              "Intel",
              "Mastercard",
              "Shopify",
              "Nutanix",
              "Seagate Technology",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "A practical application of this programming problem lies in the creation of telephone dial-in systems or mobile texting in old feature phones, where a combination of number presses resulted in different letters. The predictive text (T9 word) feature, for instance, used this method to help users type faster. The logic behind typing on old mobile phones is similar to the problem mentioned - every number corresponds to a different set of letters and a combination results in different words. Nowadays, even though smartphones with full QWERTY keyboards are dominant, this concept is very crucial for accessibility programs for visually impaired or specially-abled users.",
            "hints": [
              {
                "hint": "Use recursion to explore all combinations. For each digit, iterate over its mapped letters. Append each letter to the current combination and proceed to the next digit."
              },
              {
                "hint": "Start with an empty combination in a queue. For each digit, extend all existing combinations in the queue by appending each possible letter. Continue until all digits have been processed."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Backtracking systematically generates all combinations by exploring all possibilities at each digit. It avoids redundant computations by building combinations incrementally.",
                "question": "Why use backtracking for this problem?"
              },
              {
                "answer": "The order of combinations depends on the traversal order in the recursive or iterative approach. The problem does not specify any required order, so either lexicographical or arbitrary order is acceptable.",
                "question": "Can the order of combinations affect the result?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Define a mapping for 0 and 1 (e.g., 0→\"\" and 1→\"\"), or ignore them in the input.",
                "question": "How would you modify this problem to include digits 0 and 1?"
              },
              {
                "answer": "Sorting the mapped letters for each digit ensures the combinations are generated in lexicographical order.",
                "question": "What if a specific order (e.g., lexicographical) is required for the output?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    },
    {
      "subcategory_id": "recursion_faqs(hard)",
      "subcategory_name": "FAQs (Hard)",
      "subcategory_slug": "faqs-hard",
      "subcategory_rank": 5,
      "subcategory_type": "study",
      "problems": [
        {
          "problem_id": "recursion_recursion_faqs(hard)_palindromepartitioning",
          "problem_name": "Palindrome partitioning",
          "problem_slug": "palindrome-partitioning",
          "problem_rank": 1,
          "misc": {
            "tags": [
              "Instacart",
              "PayPal",
              "Airbnb",
              "Walmart",
              "American Express",
              "Shopify",
              "Medtronic",
              "Seagate Technology",
              "Cloudflare",
              "Morgan Stanley",
              "Siemens Healthineers",
              "Qualcomm",
              "Unity Technologies",
              "Electronic Arts",
              "Pinterest",
              "Mastercard",
              "PwC",
              "Robinhood",
              "Salesforce",
              "Stripe",
              "Visa",
              "Ubisoft",
              "Wayfair",
              "Byju's",
              "Freshworks",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "Fun Fact: This problem concept is heavily applied in building AI chatbots, particularly for checking if a sentence or phrase is the same forward and backward, an example of a palindrome. Natural language processing (NLP) is a massive part of AI chatbots that can parse, understand, and respond to user input in a way that simulates natural human conversation - the palindrome partitioning helps in this case. Besides, it's also used in DNA sequence analysis in bioinformatics, where analyzing palindromic sequences can play a critical role in understanding DNA sequences and their functions.",
            "hints": [
              {
                "hint": "Use recursion to explore all possible partitions. Backtrack to remove the last added substring and try other possibilities."
              },
              {
                "hint": "Use a helper function to check if a substring is a palindrome."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Duplicate partitions are naturally avoided because backtracking generates partitions by iterating through the string in order and only includes valid substrings.",
                "question": "How do you avoid duplicate partitions?"
              },
              {
                "answer": "The output will include all possible partitions, ranging from each character as a separate partition to the entire string as a single partition.",
                "question": "What if the input contains only palindromes?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Return the first partition found during backtracking. This reduces the search space and improves performance.",
                "question": "What if the problem required finding only one valid partition?"
              },
              {
                "answer": "Modify the recursion to include overlapping substrings. This would require additional bookkeeping to avoid duplicate results.",
                "question": "What if overlapping palindromic substrings are allowed?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs(hard)_wordsearch",
          "problem_name": "Word Search",
          "problem_slug": "word-search",
          "problem_rank": 2,
          "misc": {
            "tags": [
              "Oracle",
              "Walmart",
              "Roche",
              "JPMorgan Chase",
              "Morgan Stanley",
              "Goldman Sachs",
              "Johnson & Johnson",
              "Activision Blizzard",
              "Shopify",
              "Ernst & Young",
              "OYO Rooms",
              "Intel",
              "Teladoc Health",
              "MongoDB",
              "Epic Systems",
              "Medtronic",
              "DoorDash",
              "Western Digital",
              "Rakuten",
              "Swiggy",
              "Riot Games",
              "Salesforce",
              "McKinsey & Company",
              "IBM",
              "Zoho",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "The underlying concept of this problem is often used in word puzzle games like \"Boggle\" or \"Words With Friends\", where players are required to search for words in grids. Specifically, the logic of checking for word existence in a grid by looking horizontally or vertically - without reusing the same letter cell, is an integral part of such game development to validate a player's move.",
            "hints": [
              {
                "hint": "Start at every cell in the grid and try to match the first character of word. If a match is found, recursively explore the neighboring cells to match the subsequent characters. Mark the current cell as visited (e.g., by modifying its value temporarily) to prevent revisiting it in the same path."
              },
              {
                "hint": "If the current index of the word equals its length, it means the word is successfully found. If the current cell does not match the expected character or goes out of bounds, backtrack immediately."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Repeated characters are handled naturally since each character must be matched independently in adjacent cells.",
                "question": "What happens if the word contains repeated characters?"
              },
              {
                "answer": "Temporarily modify the grid value (e.g., set it to #) during the search. Restore it after backtracking to ensure the grid remains intact for other paths.",
                "question": "How do you handle visited cells?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the neighbor exploration step to include diagonal directions (top-left, top-right, bottom-left, bottom-right).",
                "question": "How would you handle diagonal moves?"
              },
              {
                "answer": "Modify the neighbor exploration to allow wrapping (e.g., moving off the right edge brings you to the left edge of the same row).",
                "question": "What if the word must wrap around the edges of the grid?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs(hard)_nqueen",
          "problem_name": "N Queen",
          "problem_slug": "n-queen",
          "problem_rank": 3,
          "misc": {
            "tags": [
              "Morgan Stanley",
              "Zoho",
              "Deloitte",
              "Robinhood",
              "Stripe",
              "Philips Healthcare",
              "Electronic Arts",
              "GE Healthcare",
              "Texas Instruments",
              "NVIDIA",
              "PwC",
              "Qualcomm",
              "Broadcom",
              "Mastercard",
              "Western Digital",
              "IBM",
              "Cloudflare",
              "JPMorgan Chase",
              "Lyft",
              "Roblox",
              "Bungie",
              "Snowflake",
              "Dropbox",
              "Seagate Technology",
              "HashiCorp",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "The N-Queens problem, while initially appearing as just a chess puzzle, actually has valuable implications in real-world applications. Its solution relies on a fundamental concept in technology: backtracking, which is used in recommendation algorithms, routing protocols, database queries optimizations and more. Any time you need to make a series of decisions, where each decision leads to a new set of choices, backtracking becomes a handy tool. The principles of this problem are even applied in branches of artificial intelligence for constraint satisfaction problems such as scheduling, map-coloring and Sudoku.",
            "hints": [
              {
                "hint": "Use backtracking to try placing queens row by row. "
              },
              {
                "hint": "Use sets to efficiently track conflicts in columns, main diagonals, and anti-diagonals. Prune invalid branches early to reduce unnecessary computations."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Backtracking systematically explores all possible configurations and prunes invalid ones early, making it well-suited for combinatorial problems like this.",
                "question": "Why use backtracking for this problem?"
              },
              {
                "answer": "Maintain the column index for each row where a queen is placed. Use this to build the board as a list of strings.",
                "question": "How do you construct the board from the solution?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Adjust the recursion to stop after placing k queens instead of n.",
                "question": "How would you modify the solution for a k-queens problem (fewer than n queens)?"
              },
              {
                "answer": "Use a counter instead of storing solutions. Increment the counter whenever a valid configuration is found.",
                "question": "How would you count the total number of solutions instead of returning them?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs(hard)_ratinamaze",
          "problem_name": "Rat in a Maze",
          "problem_slug": "rat-in-a-maze",
          "problem_rank": 4,
          "misc": {
            "tags": [
              "Boston Consulting Group",
              "Snowflake",
              "Unity Technologies",
              "Ubisoft",
              "OYO Rooms",
              "Broadcom",
              "Cloudflare",
              "MongoDB",
              "Chewy",
              "Teladoc Health",
              "Swiggy",
              "Splunk",
              "Walmart",
              "Johnson & Johnson",
              "Oracle",
              "Reddit",
              "Square",
              "Target",
              "Nutanix",
              "McKinsey & Company",
              "AMD",
              "Twilio",
              "ARM",
              "PwC",
              "Docker",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "This problem statement is a practical manifestation of pathfinding algorithms used in a variety of disciplines in software development. A prime example can be found in video game development, where these algorithms allow characters to navigate around obstacles in an environment. In particular, the A* (A-star) search algorithm, which incorporates heuristic information, is commonly used for its efficiency and accuracy in finding the shortest path. Additionally, similar problem-solving structures are used in web routing protocols and Global Positioning System (GPS) for finding the shortest route between two locations.",
            "hints": [
              {
                "hint": "Use recursion to explore all possible moves from the current cell. At each step, check if the current cell is valid for traversal (inside the grid, unvisited, and not blocked). If valid, mark the cell as visited and attempt to move in all four possible directions. Append the direction (U, D, L, R) to the current path while moving."
              },
              {
                "hint": "If the current cell is (n−1,n−1), it means the rat has reached the destination. Add the current path to the list of results. If the current cell is invalid (out of bounds, blocked, or already visited), return immediately without proceeding further."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Use a visited matrix or temporarily mark the grid cell as blocked (e.g., setting it to 0) while exploring it. After backtracking, restore the cell to its original state.",
                "question": "How do you ensure the rat doesn’t revisit cells in the same path?"
              },
              {
                "answer": "Each recursive path is independently constructed by appending the current direction. As long as cells are not revisited within a path, duplicate paths are naturally avoided.",
                "question": "How do you ensure all paths are distinct? "
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Instead of finding all paths, use a Breadth-First Search (BFS) approach to find the shortest path. BFS explores all possible paths layer by layer and guarantees the shortest path in unweighted grids.",
                "question": "How would you modify the algorithm to return only the shortest path?"
              },
              {
                "answer": "Add logic to track items or constraints (e.g., counting the number of specific cells visited). Include this information in the recursion state to enforce the constraints during path exploration.",
                "question": "What if the rat must collect items or satisfy constraints along the way?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs(hard)_mcoloringproblem",
          "problem_name": "M Coloring Problem",
          "problem_slug": "m-coloring-problem",
          "problem_rank": 6,
          "misc": {
            "tags": [
              "Instacart",
              "Flipkart",
              "Bain & Company",
              "Rockstar Games",
              "Qualcomm",
              "Cerner",
              "KPMG",
              "eBay",
              "Swiggy",
              "Electronic Arts",
              "Philips Healthcare",
              "Broadcom",
              "GE Healthcare",
              "Salesforce",
              "Zomato",
              "ARM",
              "Medtronic",
              "Shopify",
              "Reddit",
              "Rakuten",
              "Seagate Technology",
              "Morgan Stanley",
              "McKinsey & Company",
              "PwC",
              "Western Digital",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "The graph coloring problem is a critical concept in many real-world applications, such as register allocation in compilers, mobile radio frequency assignment, task scheduling and in Sudoku puzzles. For example, in register allocation during the compiling process, each register can be viewed as a color. The goal is to allocate the most efficiently without using the same register for intersecting live ranges of variables, similar to not coloring adjacent vertices with the same color in a graph. This graph-coloring method helps in writing efficient programs.",
            "hints": [
              {
                "hint": "This is a variation of the graph coloring problem, which is NP-complete. Start by attempting to color each vertex one by one. For each vertex, try assigning it a color from 1 to M."
              },
              {
                "hint": "\"Use an adjacency list or adjacency matrix to represent the graph. For a vertex v, a color c is valid if no vertex adjacent to v is already colored withc. This can be implemented by iterating through the neighbors of v and checking their current colors.\""
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Treat each connected component independently. If any component cannot be colored with M colors, return False.",
                "question": "How do you handle disconnected graphs?"
              },
              {
                "answer": "For each vertex, check the colors of all its neighbors before assigning a color. Use a helper function to validate color assignments.",
                "question": "How do you ensure adjacent vertices have different colors?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Directed graphs require ensuring no two vertices in a directed path share the same color. This may require reinterpreting the problem as a graph partitioning problem.",
                "question": "How would you modify this for directed graphs?"
              },
              {
                "answer": "Yes, use an iterative approach with a stack or queue to simulate the backtracking process. However, recursion is simpler and more intuitive for this problem.",
                "question": "Can this problem be solved without recursion?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "recursion_recursion_faqs(hard)_sudokosolver",
          "problem_name": "Sudoko Solver",
          "problem_slug": "sudoko-solver",
          "problem_rank": 7,
          "misc": {
            "tags": [
              "Airbnb",
              "Visa",
              "McKinsey & Company",
              "ARM",
              "Stripe",
              "Bungie",
              "Alibaba",
              "Ernst & Young",
              "Flipkart",
              "Etsy",
              "Medtronic",
              "Zoho",
              "Zomato",
              "Broadcom",
              "Riot Games",
              "Goldman Sachs",
              "Uber",
              "Zynga",
              "Databricks",
              "Activision Blizzard",
              "Freshworks",
              "Optum",
              "Micron Technology",
              "Ubisoft",
              "Texas Instruments",
              "Google",
              "Microsoft",
              "Amazon",
              "Meta",
              "Apple",
              "Netflix",
              "Adobe"
            ],
            "facts": "The concept behind solving Sudoku puzzles programmatically is often used in the real world as a common example of constraint satisfaction problems (CSPs). CSPs are mathematical questions defined as a set of objects whose state must satisfy a number of constraints or restrictions. CSPs are applied in areas like AI planning and scheduling, routing problems, and even efficiently allocating resources in large data centers. For instance, Google uses CSPs in their Or-Tools software to solve complex planning and resource allocation problems.",
            "hints": [
              {
                "hint": "Use recursion to try filling in each empty cell. For each empty cell, try placing numbers 1 through 9. After placing a number, recursively attempt to solve the rest of the puzzle."
              },
              {
                "hint": "Maintain data structures (e.g., sets or arrays) to track used numbers for each row, column, and sub-grid. This avoids repeatedly iterating over the grid to check constraints. Terminate as soon as the puzzle is solved, as only one solution exists for a valid Sudoku."
              }
            ],
            "language": [],
            "difficulty": "Hard",
            "frequently_occuring_doubts": [
              {
                "answer": "Backtracking systematically explores all possible configurations, ensuring that the solution satisfies all constraints. It is efficient for problems like Sudoku, where the solution space can be pruned early.",
                "question": "Why use backtracking for solving Sudoku?"
              },
              {
                "answer": "Validate the board before solving by checking for duplicates in rows, columns, and sub-grids. If invalid, return an appropriate error or flag.",
                "question": "How do you handle invalid Sudoku boards?"
              }
            ],
            "interview_followup_questions": [
              {
                "answer": "Modify the backtracking function to terminate after finding the first valid number for the target cell.",
                "question": "What if only partial solutions are required (e.g., fill one cell)?"
              },
              {
                "answer": "Parallelizing backtracking is challenging due to its sequential nature. However, independent sub-grids can be solved in parallel for puzzles with partial constraints.",
                "question": "Can the algorithm be parallelized?"
              }
            ]
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    },
    {
      "subcategory_id": "recursion_contest",
      "subcategory_name": "Contest",
      "subcategory_slug": "contest",
      "subcategory_rank": 6,
      "subcategory_type": "contest",
      "problems": [
        {
          "problem_id": "different_series",
          "problem_name": "Different Series",
          "problem_slug": "different-series",
          "problem_rank": 0,
          "misc": {
            "tags": [],
            "facts": " ",
            "hints": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [],
            "interview_followup_questions": []
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "combination_xor",
          "problem_name": "Combination XOR",
          "problem_slug": "combination-xor",
          "problem_rank": 1,
          "misc": {
            "tags": [],
            "facts": " ",
            "hints": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [],
            "interview_followup_questions": []
          },
          "problem_type": "DSA",
          "hasIDE": true
        },
        {
          "problem_id": "find_distinct_outcomes",
          "problem_name": "Find Distinct Expressions",
          "problem_slug": "find-distinct-expressions",
          "problem_rank": 2,
          "misc": {
            "tags": [],
            "facts": " ",
            "hints": [],
            "difficulty": "Easy",
            "frequently_occuring_doubts": [],
            "interview_followup_questions": []
          },
          "problem_type": "DSA",
          "hasIDE": true
        }
      ]
    }
  ]