import { jwtMiddleware } from "@/utils/middleware";
import {
  getTodos,
  addTodo,
  updateTodo,
  deleteTodo,
} from "@/controllers/TodoController";

// Handler para GET
export async function GET(req) {
  return jwtMiddleware(async (req) => {
    return await getTodos(req);
  })(req);
}

// Handler para POST
export async function POST(req) {
  return jwtMiddleware(async (req) => {
    return await addTodo(req);
  })(req);
}

// Handler para PUT
export async function PUT(req) {
  return jwtMiddleware(async (req) => {
    return await updateTodo(req);
  })(req);
}

// Handler para DELETE
export async function DELETE(req) {
  return jwtMiddleware(async (req) => {
    return await deleteTodo(req);
  })(req);
}
