<?php

class TreeNode
{
	var $id;
	var $text;
	//var $children= Array();
	var $leaf=true;
	var $checked	 =false;
	var $iconCls	= "dept";
	var $dep		= false;
	
	//var $expanded=false;     
	//var $expandable=true;   
	//var $draggable=true;    
	//var $disabled=false; 		
}


function createTree($arrDept,$arrStaff,$parentID, $inode)
{
	
	for($i = 0; $i < count($arrDept); $i++)
	{
		
		$dep = $arrDept[$i];
		
		if($dep->shangjibumenid == $parentID)
		{
			$node = new TreeNode();
			$node->text = $dep->bumenmingcheng;
			$node->id	= "dept" . $dep->id;
			$node->dep	= true;
			//echo json_encode($node);
			$inode->leaf	= false;
			$inode->children[]	= $node;
						
			for ($j =0; $j<count($arrStaff); $j++)
			{
				$staff1 = $arrStaff[$j];
				
				if($staff1->suoshubumen == $dep->id){
					$node1 = new TreeNode();
					
					$node1->text = $staff1->zhenshixingming;
					$node1->id	= $staff1->id;
					$node1->dep = false;
					$node->children[]	= $node1;
					$node->leaf=false;
					$node1->iconCls="staffs";
				}
			}
			
			createTree($arrDept,$arrStaff,$dep->id, $node);
		}
		
	}	

}

$node = new TreeNode();

$node->text	= "顶级目录";
$node->id	= 0;
$node->checked	= false;
$node->dep	= true;
$myechoStr	=  createTree($dept, $staff, -1, $node);
echo "[";
echo json_encode($node);
echo "]";
?>
