/* Final Project in Data Structure and Algorithm
 * 
 * Project Description: This project is JAVA programming with application 
 * and implementation of non-linear abstract data type. The group created
 * a Order Management System for "NUgawan - Lugawan sa NU" restaurant.
 * The BINARY TREE was used to represent the hierarchical structure 
 * of the menu and HASHMAP was applied to store menu items efficiently.
 * 
 * Submitted by: Group - NUgawan
 * Members:
 * 		ALLADO, Abigail
 * 		LARA, Ma. Katrina
 * 		REY, Zophia
 * 		SARMIENTO, Cherish
 */

package Final;

import java.util.*;

class FinalProject {
	Node root;
	String[][] array = new String[7][6];
	HashMap<String, Integer> orders = new HashMap<String, Integer>();
    Scanner scanner = new Scanner(System.in);
	
	public void display(int mode) {
		switch(mode) {
		case 1:
			inOrderTraversal(root);
			break;
		case 2:
			postOrderTraversal(root);
			break;
		case 3:
			preOrderTraversal(root);
			break;
		}
	}
	
	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " | ");
			inOrderTraversal(root.right);
		}
	}
	
	private void postOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
			System.out.print(root.data + " | ");
		}
	}
	
	private void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " | ");
			inOrderTraversal(root.left);
			inOrderTraversal(root.right);
		}
	}
	
	public void build2DTree() {
		array[0][0] = "  ";
		array[0][1] = "  ";
		array[0][2] = "Lugaw";
		array[0][3] = " ";
		array[0][4] = " ";
		array[0][5] = " ";
		
		array[1][0] = "  ";
		array[1][1] = "  /";
		array[1][2] = "  ";
		array[1][3] = "  \\";
		array[1][4] = " ";
		array[1][5] = " ";
		
		array[2][0] = " ";
		array[2][1] = "Plain";
		array[2][2] = " ";
		array[2][3] = "Special";
		array[2][4] = " ";
		array[2][5] = " ";
		
		array[3][0] = "  /";
		array[3][1] = "";
		array[3][2] = " \\";
		array[3][3] = "  ";
		array[3][4] = "   \\";
		array[3][5] = " ";
		
		array[4][0] = "Half";
		array[4][1] = "";
		array[4][2] = "Whole";
		array[4][3] = "";
		array[4][4] = "Tokwa";
		array[4][5] = " ";
		
		array[5][0] = "\t";
		array[5][1] = " ";
		array[5][2] = " ";
		array[5][3] = "/";
		array[5][4] = " ";
		array[5][5] = "\\";
		
		array[6][0] = " ";
		array[6][1] = " ";
		array[6][2] = " ";
		array[6][3] = "   Lechon";
		array[6][4] = "";
		array[6][5] = "Egg";	
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("");
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "  ");
			}
		}
	}
	
	public void orderingSystem() {
		while (true) {
            System.out.println("\nNUgawan - Lugawan sa NU:");
            System.out.println("1. View Menu");
            System.out.println("2. View Order");
            System.out.println("3. Finish Order");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayMenu(scanner, orders);
                    break;
                case 2:
                    viewOrder(orders, scanner);
                    break;
                case 3:
                	finishOrder(orders, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
		
		
    }
	
	private static void displayMenu(Scanner scanner, HashMap<String, Integer> orders) {
        while (true) {
            System.out.println("\n--- View Menu ---");
            System.out.println("1. Lugaw Plain");
            System.out.println("2. Lugaw Special (Toppings)");
            System.out.println("3. Drinks");
            System.out.print("Enter your choice (Press 'Enter' if done): ");
            String menuChoice = scanner.nextLine();

            switch (menuChoice) {
                case "1":
                    addLugawPlain(orders, scanner);
                    break;
                case "2":
                    addLugawSpecial(orders, scanner);
                    break;
                case "3":
                    addDrinks(orders, scanner);
                    break;
                case "":
                    return;  
                default:
                    System.out.println("Invalid choice.");
                    return;  
            }
        }
    }
	
	private static void addLugawPlain(HashMap<String, Integer> orders, Scanner scanner) {
        System.out.println("\n--- Lugaw Plain ---");
        System.out.println("1. Half | Price: ₱15");
        System.out.println("2. Whole | Price: ₱20");
        System.out.print("Enter your choice (e.g., '1' for Half or press 'Enter' to return): ");
        String lugawChoice = scanner.nextLine();
        
        switch (lugawChoice) {
	        case "1":
	        	 addOrUpdateOrder(orders, "Lugaw Plain (Half)", 1, 15.00);
	        	 break;
	        case "2":
	        	addOrUpdateOrder(orders, "Lugaw Plain (Whole)", 1, 20.00);
	        	break;
	        case "":
                return; 
        	default:
        		System.out.println("Invalid choice.");
        }
    }
	
	private static void addLugawSpecial(HashMap<String, Integer> orders, Scanner scanner) {
        System.out.println("\n--- Lugaw Special (Toppings) ---");
        System.out.println("1. Egg | Price: ₱30");
        System.out.println("2. Lechon | Price: ₱40");
        System.out.println("3. Tokwa | Price: ₱30");
        System.out.print("Enter your choice (e.g., '1' for Egg or press 'Enter' to return): ");
        String specialChoice = scanner.nextLine();
    
        switch (specialChoice) {
            case "1":
                addOrUpdateOrder(orders, "Lugaw Special with Egg", 1, 30.0);
                break;
            case "2":
                addOrUpdateOrder(orders, "Lugaw Special with Lechon", 1, 40.0);
                break;
            case "3":
                addOrUpdateOrder(orders, "Lugaw Special with Tokwa", 1, 30.0);
                break;
            case "":
                return; 
            default:
                System.out.println("Invalid topping choice.");
        }
    }
	
	private static void addDrinks(HashMap<String, Integer> orders, Scanner scanner) {
        System.out.println("\n--- Drinks ---");
        System.out.println("1. Coke | Price: ₱20");
        System.out.println("2. Royal | Price: ₱20");
        System.out.println("3. Sprite | Price: ₱20");
        System.out.println("4. Mineral | Price: ₱15");
        System.out.print("Enter your choice (e.g., '1' for Coke or press 'Enter' to return): ");
        String drinkChoice = scanner.nextLine();

        switch (drinkChoice) {
            case "1":
                addOrUpdateOrder(orders, "Coke", 1, 20.0);
                break;
            case "2":
                addOrUpdateOrder(orders, "Royal", 1, 20.0);
                break;
            case "3":
                addOrUpdateOrder(orders, "Sprite", 1, 20.0);
                break;
            case "4":
                addOrUpdateOrder(orders, "Mineral", 1, 15.0);
                break;
            case "":
                return; 
            default:
                System.out.println("Invalid drink choice.");
        }
    }
	
	private static void viewOrder(HashMap<String, Integer> orders, Scanner scanner) {
        System.out.println("\n--- View Order ---");
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        int orderNumber = 1;
        double totalCost = 0.0;

        for (HashMap.Entry<String, Integer> entry : orders.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double itemCost = getCost(item) * quantity;
            totalCost += itemCost;

            System.out.println(orderNumber + ". " + item + " x" + quantity + " - ₱" + itemCost);
            orderNumber++;
        }

        System.out.println("Total Amount: ₱" + totalCost);

        System.out.print("Remove Order (Enter Item Number, 'All', or 'None'): ");
        String removeChoice = scanner.nextLine().toLowerCase();

        if (removeChoice.equals("none")) {
            finishOrder(orders, scanner);
        } else if (removeChoice.equals("all")) {
            orders.clear();
        } else {
            int removeItemNumber = Integer.parseInt(removeChoice);
            if (removeItemNumber >= 1 && removeItemNumber <= orders.size()) {
                String[] orderKeys = orders.keySet().toArray(new String[0]);
                String itemToRemove = orderKeys[removeItemNumber - 1];
                System.out.print("Enter quantity to remove: ");
                int removeQuantity = Integer.parseInt(scanner.nextLine());

                if (removeQuantity >= 1 && removeQuantity <= orders.get(itemToRemove)) {
                    int remainingQuantity = orders.get(itemToRemove) - removeQuantity;
                    if (remainingQuantity == 0) {
                        orders.remove(itemToRemove);
                    } else {
                        orders.put(itemToRemove, remainingQuantity);
                    }
                } else {
                    System.out.println("Invalid quantity to remove.");
                }
            } else {
                System.out.println("Invalid item number.");
            }
        }
    }
	
	private static void finishOrder(HashMap<String, Integer> orders, Scanner scanner) {
        System.out.print("Finish Order (Yes/No): ");
        String finishChoice = scanner.nextLine().toLowerCase();
        if (finishChoice.equals("yes")) {
            System.out.println("Thank you for visiting NUgawan - Lugawan sa NU!");
            scanner.close();
            System.exit(0);
        }
    }

    private static void addOrUpdateOrder(HashMap<String, Integer> orders, String item, int quantity, double price) {
        if (orders.containsKey(item)) {
            orders.put(item, orders.get(item) + quantity);
        } else {
            orders.put(item, quantity);
        }
    }

    private static double getCost(String item) {
        switch (item) {
            case "Lugaw Plain (Half)":
                return 15.0;
            case "Lugaw Plain (Whole)":
                return 20.0;
            case "Lugaw Special with Egg":
                return 30.0;
            case "Lugaw Special with Lechon":
                return 40.0;
            case "Lugaw Special with Tokwa":
                return 30.0;
            case "Coke":
            case "Royal":
            case "Sprite":
                return 20.0;
            case "Mineral":
                return 15.0;
            default:
                return 0.0;
        }
    }
	
	public static void main (String[] args) {
		FinalProject project = new FinalProject();
		
		project.root = (new Node("Lugaw"));
		project.root.left = (new Node("Plain"));
		project.root.right = (new Node("Special"));
		project.root.left.left = (new Node("Half"));
		project.root.left.right = (new Node("Whole"));
		project.root.right.right = (new Node("Tokwa"));
		project.root.right.right.left = (new Node("Lechon"));
		project.root.right.right.right = (new Node("Egg"));
		
		System.out.println("------------- NUgawan - Lugawan sa NU (2-Dimension Tree) -------------");
		project.build2DTree();
		System.out.println("\n");
		
		System.out.println("-------------- NUgawan - Lugawan sa NU (Tree Traversal) --------------");
		System.out.println();
		System.out.print("Root: " + project.root.data);
		System.out.println();
		
		System.out.print("Left subtree: ");
		project.inOrderTraversal(project.root.left);
		System.out.println();
		
		System.out.print("Right subtree: ");
		project.inOrderTraversal(project.root.right);
		System.out.println();
		
		System.out.print("In-Order: ");
		project.display(1);
		System.out.println();
		
		System.out.print("Post-Order: ");
		project.display(2);
		System.out.println();
		
		System.out.print("Pre-Order: ");
		project.display(3);
		System.out.println("\n");
	
		System.out.println("----- Welcome to NUgawan - Lugawan sa NU (HashMap Implementation) -----");
		project.orderingSystem();
	}
}

class Node {
	String data;
	Node right;
	Node left;
	Node root;
	String[][] array;
	
	Node (String data) {
		this.data = data;
	}
}
