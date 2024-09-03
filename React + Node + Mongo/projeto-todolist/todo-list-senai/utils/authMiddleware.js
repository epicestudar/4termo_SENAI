import jwt from "jsonwebtoken";
import User from "../models/User";
import dbConnect from "./dbConnect";

const authMiddleware = async (req, res, next) => {
  await dbConnect();
  const { authorization } = req.headers;

  if (!authorization || !authorization.startsWith("Bearer ")) {
    return res.status(401).json({ message: "Autorização negada." });
  }

  const token = authorization.split(" ")[1];
  try {
    const decoded = jwt.verify(token, process.env.JWT_SECRET);
    req.user = await User.findById(decoded.id).select("-password");
    next();
  } catch (error) {
    res.status(401).json({ message: "Token inválido." });
  }
};

export default authMiddleware;
